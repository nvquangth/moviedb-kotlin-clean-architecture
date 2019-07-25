object Versions {
    const val appcompat = "1.1.0-alpha02"
    const val coreKtx = "1.1.0-alpha04"
    const val constraintLayout = "1.1.3"
    const val recyclerView = "1.1.0-alpha02"
    const val espressoCore = "3.2.0-alpha02"
    const val androidGradlePlugin = "3.4.1"
    const val material = "1.1.0-alpha03"
    const val vectorDrawable = "1.1.0-alpha01"

    const val kotlin = "1.3.11"
    const val lifecycleExt = "2.1.0-alpha02"
    const val koin = "1.0.2"
    const val room = "2.1.0-alpha04"
    const val rxJava = "2.2.7"
    const val rxAndroid = "2.1.1"
    const val okHttp = "3.13.1"
    const val retrofit = "2.5.0"
    const val glide = "4.9.0"
    const val dataBinding = "3.4.1"
    const val multidex = "2.0.1"

    /**
     * Testing
     */
    const val coreTesting = "1.1.0"
    const val junit = "4.12"
    const val runner = "1.1.2-alpha02"
    const val mockito = "3.0.0"
    const val mockNhaarman = "2.1.0"
}

object BuildPlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
}

object Android {
    const val minSdk = 15
    const val targetSdk = 28
    const val applicationId = "com.example.clean"
    const val versionCode = 1
    var versionName = "1.0.0"
}

object GradlePlugins {
    const val android = "com.android.application"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val javaLib = "java-library"
    const val androidLib = "com.android.library"
    const val kotlinAndroidExt = "kotlin-android-extensions"
}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object AndroidJUnit {
    const val runner = "android.support.test.runner.AndroidJUnitRunner"
}

object BuildType {
    const val debug = "debug"
    const val release = "release"

    const val minifyRelease = true
    const val proguarRelease = "proguard-rules.pro"

    const val minifyDebug = false
    const val proguarDebug = "proguard-rules.pro"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val vectorDrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawable}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExt}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleExt}"

    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val roomCore = "androidx.room:room-runtime:${Versions.room}"
    const val roomJava = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomComplier = "androidx.room:room-compiler:${Versions.room}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val dataBindingCompiler = "androidx.databinding:databinding-compiler:${Versions.dataBinding}"

    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    /**
     * Testing
     */
    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val mockNhaarman = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockNhaarman}"
}