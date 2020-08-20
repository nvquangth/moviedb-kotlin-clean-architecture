plugins {
    id(GradlePlugins.kotlin)
}
dependencies {
    implementation(BuildPlugins.stdlib)

    // Coroutines
    implementation(Libs.coroutines)

    // Koin
    implementation(Libs.koin)
    implementation(Libs.koinScope)
}