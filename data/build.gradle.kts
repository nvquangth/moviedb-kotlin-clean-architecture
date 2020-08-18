plugins {
    id(GradlePlugins.androidApplication)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinExt)
    id(GradlePlugins.kotlinKapt)
}

android {
    compileSdkVersion(Android.compileSdk)

    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)

        testInstrumentationRunner = AndroidJUnit.testInstrumentationRunner
    }

    buildTypes {
        getByName(BuildType.debug) {
            isMinifyEnabled = BuildType.minifyDebug
            proguardFile(BuildType.proguardDebug)
        }

        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFile(BuildType.proguardRelease)
        }
    }

    flavorDimensions("version")
    productFlavors {
        create(ProductFlavor.develop) {
            applicationId = ProductFlavor.applicationIdDevelop
            versionCode = ProductFlavor.versionCodeDevelop
            versionName = ProductFlavor.versionNameDevelop

            buildConfigField(
                "String",
                ProductFlavor.baseUrlParam,
                ProductFlavor.baseUrlDevelop
            )
        }

        create(ProductFlavor.staging) {
            applicationId = ProductFlavor.applicationIdStaging
            versionCode = ProductFlavor.versionCodeStaging
            versionName = ProductFlavor.versionNameStaging

            buildConfigField(
                "String",
                ProductFlavor.baseUrlParam,
                ProductFlavor.baseUrlStaging
            )
        }

        create(ProductFlavor.production) {
            applicationId = ProductFlavor.applicationIdProduction
            versionCode = ProductFlavor.versionCodeProduction
            versionName = ProductFlavor.versionNameProduct

            buildConfigField(
                "String",
                ProductFlavor.baseUrlParam,
                ProductFlavor.baseUrlProduction
            )
        }
    }
}

dependencies {
    implementation(project(Modules.domain))

    implementation(BuildPlugins.stdlib)

    // Koin
    implementation(Libs.koin)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)

    // Room
    implementation(Libs.room)
    implementation(Libs.roomExt)
    kapt(Libs.roomProcessor)

    // Retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofitGson)

    // OkHttp
    implementation(Libs.okHttp)
    implementation(Libs.okHttpLogging)
    testImplementation(Libs.okHttpMockServer)

    // JUnit
    testImplementation(Libs.jUnit)
    androidTestImplementation(Libs.jUnitExt)
    androidTestImplementation(Libs.espresso)

    // Mockito
    implementation(Libs.mockito)
}