/*
 * SLF4K - A set of SLF4J extensions for Kotlin to make logging more idiomatic.
 * Copyright (c) 2022-2024 solonovamax <solonovamax@12oclockpoint.com>
 *
 * The file KLoggerCache.kt is part of SLF4K
 * Last modified on 22-09-2024 06:40 p.m.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * SLF4K IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.slf4j.kotlin

import java.util.concurrent.ConcurrentHashMap

/**
 * A cache of [KLoggerDelegate]s.
 */
public object KLoggerCache {
    private val loggerDelegateCache: MutableMap<String, KLoggerDelegate<*>> = ConcurrentHashMap()

    /**
     * Retrieves a [KLoggerDelegate] for a given class.
     */
    public fun <T : Any> loggerDelegate(clazz: Class<T>): KLoggerDelegate<T> {
        @Suppress("UNCHECKED_CAST")
        return loggerDelegateCache.getOrPut(clazz.name) {
            KLoggerDelegate<T> {
                loggerNameForClass(clazz)
            }
        } as KLoggerDelegate<T>
    }

    /**
     * Retrieves a [KLoggerDelegate] for a given name.
     */
    public fun loggerDelegate(name: String): KLoggerDelegate<*> {
        return loggerDelegateCache.getOrPut(name) {
            KLoggerDelegate<Any> { name }
        }
    }

    private fun loggerNameForClass(clazz: Class<*>): String {
        val name = clazz.name
        val sliced = name.substringBefore("$") // remove all the bullshit like MainKt$main$$inlined$readValue$1

        return when { // top level files will have "Kt" added. Remove that. eg. MainKt -> Main.
            sliced.endsWith("Kt") -> sliced.substringBeforeLast("Kt")
            else                  -> sliced
        }
    }
}
