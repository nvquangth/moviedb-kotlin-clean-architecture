plugins {
    id(com.example.buildSrc.GradlePlugins.kotlin)
}
dependencies {
    implementation(com.example.buildSrc.BuildPlugins.stdlib)

    // Koin
    implementation(com.example.buildSrc.Libs.koin)
    implementation(com.example.buildSrc.Libs.koinScope)
    implementation(com.example.buildSrc.Libs.koinViewModel)
}