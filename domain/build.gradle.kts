plugins {
    id(GradlePlugins.kotlin)
}
dependencies {
    implementation(BuildPlugins.stdlib)

    implementation(Libs.coroutines)

    // Koin
    implementation(Libs.koin)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)
}