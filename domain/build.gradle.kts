plugins {
    id(com.example.buildSrc.GradlePlugins.kotlin)
    id(com.example.buildSrc.GradlePlugins.kotlinKapt)
}
dependencies {
    implementation(com.example.buildSrc.BuildPlugins.stdlib)

    implementation(com.example.buildSrc.Libs.coroutines)

    // Koin
    implementation(com.example.buildSrc.Libs.koin)
    implementation(com.example.buildSrc.Libs.koinScope)
    implementation(com.example.buildSrc.Libs.koinViewModel)
}