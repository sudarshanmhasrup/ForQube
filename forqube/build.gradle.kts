plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinCompose)
    alias(libs.plugins.composeDesktop)
}

repositories {
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    runtimeOnly("androidx.compose.ui:ui-tooling-preview:1.7.1")
}
