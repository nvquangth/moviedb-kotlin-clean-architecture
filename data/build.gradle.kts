plugins {
    id(com.example.buildSrc.GradlePlugins.androidApplication)
    id(com.example.buildSrc.GradlePlugins.kotlinAndroid)
    id(com.example.buildSrc.GradlePlugins.kotlinExt)
    id(com.example.buildSrc.GradlePlugins.kotlinKapt)
}

android {
    compileSdkVersion(com.example.buildSrc.Android.compileSdk)

    defaultConfig {
        minSdkVersion(com.example.buildSrc.Android.minSdk)
        targetSdkVersion(com.example.buildSrc.Android.targetSdk)

        testInstrumentationRunner = com.example.buildSrc.AndroidJUnit.testInstrumentationRunner
    }

    buildTypes {
        getByName(com.example.buildSrc.BuildType.debug) {
            isMinifyEnabled = com.example.buildSrc.BuildType.minifyDebug
            proguardFile(com.example.buildSrc.BuildType.proguardDebug)
        }

        getByName(com.example.buildSrc.BuildType.release) {
            isMinifyEnabled = com.example.buildSrc.BuildType.minifyRelease
            proguardFile(com.example.buildSrc.BuildType.proguardRelease)
        }
    }

    flavorDimensions("version")
    productFlavors {
        create(com.example.buildSrc.ProductFlavor.develop) {
            applicationId = com.example.buildSrc.ProductFlavor.applicationIdDevelop
            versionCode = com.example.buildSrc.ProductFlavor.versionCodeDevelop
            versionName = com.example.buildSrc.ProductFlavor.versionNameDevelop

            buildConfigField(
                "String",
                com.example.buildSrc.ProductFlavor.baseUrlParam,
                com.example.buildSrc.ProductFlavor.baseUrlDevelop
            )
        }

        create(com.example.buildSrc.ProductFlavor.staging) {
            applicationId = com.example.buildSrc.ProductFlavor.applicationIdStaging
            versionCode = com.example.buildSrc.ProductFlavor.versionCodeStaging
            versionName = com.example.buildSrc.ProductFlavor.versionNameStaging

            buildConfigField(
                "String",
                com.example.buildSrc.ProductFlavor.baseUrlParam,
                com.example.buildSrc.ProductFlavor.baseUrlStaging
            )
        }

        create(com.example.buildSrc.ProductFlavor.production) {
            applicationId = com.example.buildSrc.ProductFlavor.applicationIdProduction
            versionCode = com.example.buildSrc.ProductFlavor.versionCodeProduction
            versionName = com.example.buildSrc.ProductFlavor.versionNameProduct

            buildConfigField(
                "String",
                com.example.buildSrc.ProductFlavor.baseUrlParam,
                com.example.buildSrc.ProductFlavor.baseUrlProduction
            )
        }
    }
}

dependencies {
    implementation(project(com.example.buildSrc.Modules.domain))

    implementation(com.example.buildSrc.BuildPlugins.stdlib)

    // Koin
    implementation(com.example.buildSrc.Libs.koin)
    implementation(com.example.buildSrc.Libs.koinScope)
    implementation(com.example.buildSrc.Libs.koinViewModel)

    // Room
    implementation(com.example.buildSrc.Libs.room)
    implementation(com.example.buildSrc.Libs.roomExt)
    kapt(com.example.buildSrc.Libs.roomProcessor)

    // Retrofit
    implementation(com.example.buildSrc.Libs.retrofit)
    implementation(com.example.buildSrc.Libs.retrofitGson)

    // OkHttp
    implementation(com.example.buildSrc.Libs.okHttp)
    implementation(com.example.buildSrc.Libs.okHttpLogging)
    testImplementation(com.example.buildSrc.Libs.okHttpMockServer)

    // JUnit
    testImplementation(com.example.buildSrc.Libs.jUnit)
    androidTestImplementation(com.example.buildSrc.Libs.jUnitExt)
    androidTestImplementation(com.example.buildSrc.Libs.espresso)

    // Mockito
    implementation(com.example.buildSrc.Libs.mockito)
}