/*
 * SLF4K - A set of SLF4J extensions for Kotlin to make logging more idiomatic.
 * Copyright (c) 2021-2024 solonovamax <solonovamax@12oclockpoint.com>
 *
 * The file LoggingExtensions.kt is part of SLF4K
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

import org.slf4j.Marker

/**
 * Log a message at the TRACE level.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.trace(crossinline message: () -> String) {
    if (isTraceEnabled)
        trace(message())
}

/**
 * Log an object at the TRACE level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param message a lazy evaluated block providing the object to be logged
 */
@JvmSynthetic
@JvmName("traceObject")
public inline fun KLogger.trace(crossinline message: () -> Any?) {
    if (isTraceEnabled)
        trace(message().toString())
}

/**
 * Log an exception (throwable) at the TRACE level with an accompanying
 * message.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.trace(throwable: Throwable?, crossinline message: () -> String) {
    if (isTraceEnabled)
        trace(message(), throwable)
}

/**
 * Log an exception (throwable) at the TRACE level with an accompanying
 * message.
 *
 * [toString] is invoked on the provided object.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the object to be logged
 */
@JvmSynthetic
@JvmName("traceObject")
public inline fun KLogger.trace(throwable: Throwable?, crossinline message: () -> Any?) {
    if (isTraceEnabled)
        trace(message().toString(), throwable)
}

/**
 * Log a message with the specific Marker at the TRACE level.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.trace(marker: Marker?, crossinline message: () -> String) {
    if (isTraceEnabled)
        trace(marker, message())
}

/**
 * Log a message with the specific Marker at the TRACE level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the object to be logged
 */
@JvmSynthetic
@JvmName("traceObject")
public inline fun KLogger.trace(marker: Marker?, crossinline message: () -> Any?) {
    if (isTraceEnabled)
        trace(message().toString(), marker)
}

/**
 * This method is similar to [trace] method except that the marker data is
 * also taken into consideration.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.trace(marker: Marker?, throwable: Throwable?, crossinline message: () -> String) {
    if (isTraceEnabled)
        trace(marker, message(), throwable)
}

/**
 * This method is similar to [trace] method except that the marker data is
 * also taken into consideration.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the object to be logged
 */
@JvmSynthetic
@JvmName("traceObject")
public inline fun KLogger.trace(marker: Marker?, throwable: Throwable?, crossinline message: () -> Any?) {
    if (isTraceEnabled)
        trace(message().toString(), marker, throwable)
}

/**
 * Log a message at the DEBUG level.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.debug(crossinline message: () -> String) {
    if (isDebugEnabled)
        debug(message())
}

/**
 * Log an object at the DEBUG level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param message a lazy evaluated block providing the object to be logged
 */
@JvmSynthetic
@JvmName("debugObject")
public inline fun KLogger.debug(crossinline message: () -> Any?) {
    if (isDebugEnabled)
        debug(message().toString())
}

/**
 * Log an exception (throwable) at the DEBUG level with an accompanying
 * message.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.debug(throwable: Throwable?, crossinline message: () -> String) {
    if (isDebugEnabled)
        debug(message(), throwable)
}

/**
 * Log an exception (throwable) at the DEBUG level with an accompanying
 * message.
 *
 * [toString] is invoked on the provided object.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("debugObject")
public inline fun KLogger.debug(throwable: Throwable?, crossinline message: () -> Any?) {
    if (isDebugEnabled)
        debug(message().toString(), throwable)
}

/**
 * Log a message with the specific Marker at the DEBUG level.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.debug(marker: Marker?, crossinline message: () -> String) {
    if (isDebugEnabled)
        debug(marker, message())
}

/**
 * Log a message with the specific Marker at the DEBUG level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("debugObject")
public inline fun KLogger.debug(marker: Marker?, crossinline message: () -> Any?) {
    if (isDebugEnabled)
        debug(message().toString(), marker)
}

/**
 * This method is similar to [debug] method except that the marker data is
 * also taken into consideration.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.debug(marker: Marker?, throwable: Throwable?, crossinline message: () -> String) {
    if (isDebugEnabled)
        debug(marker, message(), throwable)
}

/**
 * This method is similar to [debug] method except that the marker data is
 * also taken into consideration.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("debugObject")
public inline fun KLogger.debug(marker: Marker?, throwable: Throwable?, crossinline message: () -> Any?) {
    if (isDebugEnabled)
        debug(message().toString(), marker, throwable)
}

/**
 * Log a message at the INFO level.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.info(crossinline message: () -> String) {
    if (isInfoEnabled)
        info(message())
}

/**
 * Log a message at the INFO level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("infoObject")
public inline fun KLogger.info(crossinline message: () -> Any?) {
    if (isInfoEnabled)
        info(message().toString())
}

/**
 * Log an exception (throwable) at the INFO level with an accompanying
 * message.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.info(throwable: Throwable?, crossinline message: () -> String) {
    if (isInfoEnabled)
        info(message(), throwable)
}

/**
 * Log an exception (throwable) at the INFO level with an accompanying
 * message.
 *
 * [toString] is invoked on the provided object.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("infoObject")
public inline fun KLogger.info(throwable: Throwable?, crossinline message: () -> Any?) {
    if (isInfoEnabled)
        info(message().toString(), throwable)
}

/**
 * Log a message with the specific Marker at the INFO level.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.info(marker: Marker?, crossinline message: () -> String) {
    if (isInfoEnabled)
        info(marker, message())
}

/**
 * Log a message with the specific Marker at the INFO level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("infoObject")
public inline fun KLogger.info(marker: Marker?, crossinline message: () -> Any?) {
    if (isInfoEnabled)
        info(message().toString(), marker)
}

/**
 * This method is similar to [info] method except that the marker data is
 * also taken into consideration.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.info(marker: Marker?, throwable: Throwable?, crossinline message: () -> String) {
    if (isInfoEnabled)
        info(marker, message(), throwable)
}

/**
 * This method is similar to [info] method except that the marker data is
 * also taken into consideration.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("infoObject")
public inline fun KLogger.info(marker: Marker?, throwable: Throwable?, crossinline message: () -> Any?) {
    if (isInfoEnabled)
        info(message().toString(), marker, throwable)
}

/**
 * Log a message at the WARN level.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.warn(crossinline message: () -> String) {
    if (isWarnEnabled)
        warn(message())
}

/**
 * Log a message at the WARN level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("warnObject")
public inline fun KLogger.warn(crossinline message: () -> Any?) {
    if (isWarnEnabled)
        warn(message().toString())
}

/**
 * Log an exception (throwable) at the WARN level with an accompanying
 * message.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.warn(throwable: Throwable?, crossinline message: () -> String) {
    if (isWarnEnabled)
        warn(message(), throwable)
}

/**
 * Log an exception (throwable) at the WARN level with an accompanying
 * message.
 *
 * [toString] is invoked on the provided object.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("warnObject")
public inline fun KLogger.warn(throwable: Throwable?, crossinline message: () -> Any?) {
    if (isWarnEnabled)
        warn(message().toString(), throwable)
}

/**
 * Log a message with the specific Marker at the WARN level.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.warn(marker: Marker?, crossinline message: () -> String) {
    if (isWarnEnabled)
        warn(marker, message())
}

/**
 * Log a message with the specific Marker at the WARN level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("warnObject")
public inline fun KLogger.warn(marker: Marker?, crossinline message: () -> Any?) {
    if (isWarnEnabled)
        warn(message().toString(), marker)
}

/**
 * This method is similar to [warn] method except that the marker data is
 * also taken into consideration.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.warn(marker: Marker?, throwable: Throwable?, crossinline message: () -> String) {
    if (isWarnEnabled)
        warn(marker, message(), throwable)
}

/**
 * This method is similar to [warn] method except that the marker data is
 * also taken into consideration.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("warnObject")
public inline fun KLogger.warn(marker: Marker?, throwable: Throwable?, crossinline message: () -> Any?) {
    if (isWarnEnabled)
        warn(message().toString(), marker, throwable)
}

/**
 * Log a message at the ERROR level.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.error(crossinline message: () -> String) {
    if (isErrorEnabled)
        error(message())
}

/**
 * Log a message at the ERROR level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("errorObject")
public inline fun KLogger.error(crossinline message: () -> Any?) {
    if (isErrorEnabled)
        error(message().toString())
}

/**
 * Log an exception (throwable) at the ERROR level with an accompanying
 * message.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.error(throwable: Throwable?, crossinline message: () -> String) {
    if (isErrorEnabled)
        error(message(), throwable)
}

/**
 * Log an exception (throwable) at the ERROR level with an accompanying
 * message.
 *
 * [toString] is invoked on the provided object.
 *
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("errorObject")
public inline fun KLogger.error(throwable: Throwable?, crossinline message: () -> Any?) {
    if (isErrorEnabled)
        error(message().toString(), throwable)
}

/**
 * Log a message with the specific Marker at the ERROR level.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.error(marker: Marker?, crossinline message: () -> String) {
    if (isErrorEnabled)
        error(marker, message())
}

/**
 * Log a message with the specific Marker at the ERROR level.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param message a lazy evaluated block providing the format string to be
 *         logged
 */
@JvmSynthetic
@JvmName("errorObject")
public inline fun KLogger.error(marker: Marker?, crossinline message: () -> Any?) {
    if (isErrorEnabled)
        error(message().toString(), marker)
}

/**
 * This method is similar to [error] method except that the marker data is
 * also taken into consideration.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
public inline fun KLogger.error(marker: Marker?, throwable: Throwable?, crossinline message: () -> String) {
    if (isErrorEnabled)
        error(marker, message(), throwable)
}

/**
 * This method is similar to [error] method except that the marker data is
 * also taken into consideration.
 *
 * [toString] is invoked on the provided object.
 *
 * @param marker the marker data specific to this log statement
 * @param throwable the exception (throwable) to log
 * @param message a lazy evaluated block providing the message string to be
 *         logged
 */
@JvmSynthetic
@JvmName("errorObject")
public inline fun KLogger.error(marker: Marker?, throwable: Throwable?, crossinline message: () -> Any?) {
    if (isErrorEnabled)
        error(message().toString(), marker, throwable)
}
