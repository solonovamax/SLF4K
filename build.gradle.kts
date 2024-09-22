/*
 * SLF4K - A set of SLF4J extensions for Kotlin to make logging more idiomatic.
 * Copyright (c) 2021-2024 solonovamax <solonovamax@12oclockpoint.com>
 *
 * The file build.gradle.kts is part of SLF4K
 * Last modified on 22-09-2024 06:41 p.m.
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

@file:Suppress("UnstableApiUsage")

import ca.solostudios.nyx.util.soloStudios
import java.time.Year
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import kotlin.math.max

plugins {
    java
    signing
    `java-library`
    `maven-publish`

    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.dokka)

    alias(libs.plugins.axion.release)

    alias(libs.plugins.nyx)
}

nyx {
    info {
        name = "SLF4K"
        module = "slf4k"
        group = "ca.solo-studios"
        version = scmVersion.version
        description = """
            A set of SLF4J extensions for Kotlin to make logging more idiomatic.
        """.trimIndent()

        organizationName = "Solo Studios"
        organizationUrl = "https://solo-studios.ca/"

        repository.fromGithub("solo-studios", "SLF4K")

        license.useMIT()

        developer {
            id.set("solonovamax")
            name.set("solonovamax")
            email.set("solonovamax@12oclockpoint.com")
            url.set("https://github.com/solonovamax")
        }
    }

    compile {
        jvmTarget = 8
        sourcesJar = true
        javadocJar = true
        allWarnings = true
        warningsAsErrors = true
        distributeLicense = true
        buildDependsOnJar = true
        reproducibleBuilds = true

        kotlin {
            withExplicitApi()
            apiVersion = "1.7"
        }
    }
    publishing {
        withSignedPublishing()

        repositories {
            maven {
                name = "SonatypeStaging"
                val repositoryId: String? by project
                url = when {
                    repositoryId != null -> uri("https://s01.oss.sonatype.org/service/local/staging/deployByRepositoryId/$repositoryId/")
                    else                 -> uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                }
                credentials(PasswordCredentials::class)
            }
            maven {
                name = "SoloStudiosReleases"
                url = uri("https://maven.solo-studios.ca/releases/")
                credentials(PasswordCredentials::class)
                authentication { // publishing doesn't work without this for some reason
                    create<BasicAuthentication>("basic")
                }
            }
            maven {
                name = "SoloStudiosSnapshots"
                url = uri("https://maven.solo-studios.ca/snapshots/")
                credentials(PasswordCredentials::class)
                authentication { // publishing doesn't work without this for some reason
                    create<BasicAuthentication>("basic")
                }
            }
        }
    }
}

repositories {
    soloStudios()
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)

    api(libs.slf4j)

    compileOnlyApi(libs.kotlinx.coroutines)
    compileOnlyApi(libs.kotlinx.coroutines.slf4j)

    kspTest(libs.ksp.service)
    testCompileOnly(libs.ksp.service)


    testImplementation(libs.slf4j.simple)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlinx.coroutines)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.coroutines.debug)

    testImplementation(libs.bundles.junit)
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()

        failFast = false
        maxParallelForks = max(Runtime.getRuntime().availableProcessors() - 1, 1)
    }

    val processDokkaIncludes by registering(ProcessResources::class) {
        group = JavaBasePlugin.DOCUMENTATION_GROUP
        description = "Processes the included dokka files"
        from(projectDir.resolve("dokka/includes")) {
            val projectInfo = ProjectInfo(nyx.info.group, nyx.info.module.get(), nyx.info.version)
            filesMatching("Module.md") {
                expand(
                    "project" to projectInfo,
                    "versions" to mapOf(
                        "slf4j" to libs.versions.slf4j.get(),
                        "kotlinxCoroutines" to libs.versions.kotlinx.coroutines.get(),
                    ),
                )
            }
        }
        destinationDir = layout.buildDirectory.dir("dokka-include").map { it.asFile }.get()
    }

    withType<DokkaTask>().configureEach {
        group = JavaBasePlugin.DOCUMENTATION_GROUP

        dependsOn(processDokkaIncludes)

        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            footerMessage = "© ${Year.now()} Copyright solo-studios"
            separateInheritedMembers = true
        }

        dokkaSourceSets.configureEach {
            includes.from(processDokkaIncludes.map { it.destinationDir.walk().filter { file -> file.isFile }.toList() })

            jdkVersion.set(8)
            reportUndocumented.set(true)

            // Documentation link
            sourceLink {
                localDirectory = projectDir.resolve("src")
                remoteUrl = nyx.info.repository.projectUrl.map { uri("$it/tree/master/src").toURL() }
                remoteLineSuffix = "#L"
            }

            externalDocumentationLink("https://www.slf4j.org/api/", "https://www.slf4j.org/api/element-list")
        }
    }
}

val Project.isSnapshot: Boolean
    get() = version.toString().endsWith("-SNAPSHOT")

data class ProjectInfo(val group: String, val module: String, val version: String)
