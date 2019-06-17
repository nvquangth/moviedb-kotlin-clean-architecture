import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id(GradlePlugins.android)
    id(GradlePlugins.kotlinAndroidExt)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
    kotlin(GradlePlugins.kotlinExt)
}

android {
    compileSdkVersion(Android.targetSdk)
    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = Android.versionCode
        versionName = Android.versionName

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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        configure(delegateClosureOf<AndroidExtensionsExtension> {
            isExperimental = true
        })
    }
}

dependencies {
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(Libs.stdlib)
    implementation(Libs.appcompat)
    implementation(Libs.coreKtx)
    implementation(Libs.constraintLayout)
    implementation(Libs.recyclerView)
    implementation(Libs.material)
    implementation(Libs.vectorDrawable)

    implementation(Libs.lifecycle)
    implementation(Libs.lifecycleJava8)

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

    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    testImplementation(Libs.junit)
    testImplementation(Libs.runner)
    testImplementation(Libs.espressoCore)

    kapt(Libs.dataBindingCompiler)
}