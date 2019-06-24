plugins {
    id(GradlePlugins.javaLib)
    id(GradlePlugins.kotlin)
}
dependencies {
    implementation(Libs.stdlib)

    implementation(Libs.koinCore)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)

    implementation(Libs.roomCore)
    implementation(Libs.roomJava)
}