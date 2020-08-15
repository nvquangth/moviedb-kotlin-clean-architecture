plugins {
    id(com.example.buildSrc.GradlePlugins.androidApplication)
    id(com.example.buildSrc.GradlePlugins.kotlinAndroid)
    id(com.example.buildSrc.GradlePlugins.kotlinExt)
    id(com.example.buildSrc.GradlePlugins.kotlinKapt)
    id(com.example.buildSrc.GradlePlugins.navSafeArg)
}

android {
    compileSdkVersion(com.example.buildSrc.Android.compileSdk)
    buildToolsVersion(com.example.buildSrc.Android.buildTools)

    defaultConfig {
        applicationId = com.example.buildSrc.Android.applicationId

        minSdkVersion(com.example.buildSrc.Android.minSdk)
        targetSdkVersion(com.example.buildSrc.Android.targetSdk)

        versionCode = com.example.buildSrc.Android.versionCode
        versionName = com.example.buildSrc.Android.versionNam

        testInstrumentationRunner = com.example.buildSrc.AndroidJUnit.testInstrumentationRunner

        multiDexEnabled = true
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
        }

        create(com.example.buildSrc.ProductFlavor.staging) {
            applicationId = com.example.buildSrc.ProductFlavor.applicationIdStaging
            versionCode = com.example.buildSrc.ProductFlavor.versionCodeStaging
            versionName = com.example.buildSrc.ProductFlavor.versionNameStaging
        }

        create(com.example.buildSrc.ProductFlavor.production) {
            applicationId = com.example.buildSrc.ProductFlavor.applicationIdProduction
            versionCode = com.example.buildSrc.ProductFlavor.versionCodeProduction
            versionName = com.example.buildSrc.ProductFlavor.versionNameProduct
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
    }
}

dependencies {
    implementation(project(com.example.buildSrc.Modules.data))
    implementation(project(com.example.buildSrc.Modules.domain))

    implementation(com.example.buildSrc.BuildPlugins.stdlib)

    // ConstraintLayout
    implementation(com.example.buildSrc.Libs.constraintLayout)

    // Appcompat
    implementation(com.example.buildSrc.Libs.appcompat)

    // Android Core
    implementation(com.example.buildSrc.Libs.coreKtx)

    // ViewModel + LiveData Lifecycle
    implementation(com.example.buildSrc.Libs.viewModel)
    implementation(com.example.buildSrc.Libs.liveData)
    implementation(com.example.buildSrc.Libs.lifecycleProcessor)

    // Multidex
    implementation(com.example.buildSrc.Libs.multidex)

    // Navigation
    implementation(com.example.buildSrc.Libs.navigationFragment)
    implementation(com.example.buildSrc.Libs.navigationUi)

    // RecyclerView
    implementation(com.example.buildSrc.Libs.recyclerView)

    // Room
    implementation(com.example.buildSrc.Libs.room)
    implementation(com.example.buildSrc.Libs.roomExt)
    kapt(com.example.buildSrc.Libs.roomProcessor)

    // ViewPager2
    implementation(com.example.buildSrc.Libs.viewPager2)

    // Koin
    implementation(com.example.buildSrc.Libs.koin)
    implementation(com.example.buildSrc.Libs.koinScope)
    implementation(com.example.buildSrc.Libs.koinViewModel)

    // Retrofit
    implementation(com.example.buildSrc.Libs.retrofit)
    implementation(com.example.buildSrc.Libs.retrofitGson)

    // OkHttp
    implementation(com.example.buildSrc.Libs.okHttp)
    implementation(com.example.buildSrc.Libs.okHttpLogging)
    testImplementation(com.example.buildSrc.Libs.okHttpMockServer)

    // Glide
    implementation(com.example.buildSrc.Libs.glide)
    kapt(com.example.buildSrc.Libs.glideProcessor)

    // JUnit
    testImplementation(com.example.buildSrc.Libs.jUnit)
    androidTestImplementation(com.example.buildSrc.Libs.jUnitExt)
    androidTestImplementation(com.example.buildSrc.Libs.espresso)

    // Mockito
    implementation(com.example.buildSrc.Libs.mockito)

    // Material Design
    implementation(com.example.buildSrc.Libs.material)

    // CardView
    implementation(com.example.buildSrc.Libs.cardView)

    // Preference
    implementation(com.example.buildSrc.Libs.preference)

    // SwipeRefreshLayout
    implementation(com.example.buildSrc.Libs.swipeRefreshLayout)
}