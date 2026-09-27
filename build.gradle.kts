plugins {
    id("com.android.application") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
}

val externalBuildDir = (System.getenv("IQOO_BUILD_DIR") ?: providers.gradleProperty("IQOO_BUILD_DIR").orNull)
    ?.takeIf { it.isNotBlank() }
    ?.let(::file)

if (externalBuildDir != null) {
    allprojects {
        layout.buildDirectory.set(externalBuildDir.resolve(project.name))
    }
}
