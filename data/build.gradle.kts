plugins {
    id(GradlePlugins.androidLib)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
}

android {
    compileSdkVersion(Android.targetSdk)

    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)

        testInstrumentationRunner = AndroidJUnit.runner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguarRelease)
        }

        getByName(BuildType.debug) {
            isMinifyEnabled = BuildType.minifyDebug
            proguardFiles(BuildType.proguarDebug)
        }
    }
}

dependencies {
    implementation(project(Modules.domain))

    implementation(Libs.stdlib)

    implementation(Libs.koinCore)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)

    implementation(Libs.roomCore)
    implementation(Libs.roomJava)
    kapt(Libs.roomComplier)

    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)

    implementation(Libs.retrofit)
    implementation(Libs.retrofitGson)
    implementation(Libs.retrofitAdapter)
    implementation(Libs.okHttp)
    implementation(Libs.okHttpLogging)

    testImplementation(Libs.junit)
    testImplementation(Libs.runner)
    testImplementation(Libs.espressoCore)
}