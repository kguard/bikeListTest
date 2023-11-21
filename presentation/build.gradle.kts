plugins {
    id(Plugins.Path.AndroidApplication)
    id(Plugins.Path.JetBrainKotlinAndroid)
    id(Plugins.NameTag.KotlinKAPT)
    id(Plugins.Path.NavigationSafeArgs)
    id(Plugins.NameTag.DaggerHiltAndroid)
}

android {
    namespace = AppConfig.ApplicationId
    compileSdk = AppConfig.CompileSdk

    defaultConfig {
        applicationId = AppConfig.ApplicationId
        minSdk = AppConfig.MinSdk
        targetSdk = AppConfig.TargetSdk
        versionCode = AppConfig.VersionCode
        versionName = AppConfig.VersionName

        testInstrumentationRunner = AppConfig.TestInstrumentationRunner

    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.DefaultProguardFile),
                AppConfig.Proguard
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.JvmTarget
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(Dependencies.AndroidX.CoreKtx)
    implementation(Dependencies.AndroidX.Appcompat)
    implementation(Dependencies.Google.AndroidMaterial)
    implementation(Dependencies.AndroidX.Constraintlayout)
    testImplementation(Dependencies.Test.Junit)
    androidTestImplementation(Dependencies.Test.TestExtJunit)
    androidTestImplementation(Dependencies.Test.TestEspressoCore)
    //View
    implementation(Dependencies.AndroidX.ActivityKtx)
    implementation(Dependencies.AndroidX.FragmentKtx)
    //Navigation
    implementation(Dependencies.AndroidX.NavigationUiKtx)
    implementation(Dependencies.AndroidX.NavigationFragmentKtx)
    //lifecycle
    implementation(Dependencies.AndroidX.LifecycleViewModelKtx)
    implementation(Dependencies.AndroidX.LifecycleRuntimeKtx)
    implementation(Dependencies.AndroidX.LifecycleLivedataKtx)
    //Coroutines
    implementation(Dependencies.Coroutine.CoroutinesCore)
    implementation(Dependencies.Coroutine.CoroutinesAndroid)
    //DaggerHilt
    implementation(Dependencies.DaggerHilt.HiltAndroid)
    kapt(Dependencies.DaggerHilt.HiltCompiler)
    kapt(Dependencies.DaggerHilt.HiltAndroidCompiler)
    //retrofit
    implementation(Dependencies.Retrofit.Retrofit)
    implementation(Dependencies.Retrofit.RetrofitGsonConverter)
    //Okhttp
    implementation(Dependencies.Okhttp.Okhttp)
    implementation(Dependencies.Okhttp.LoggingInterceptor)
    implementation(Dependencies.Okhttp.UrlConnection)
    //Jetpack Compose
    implementation(platform(Dependencies.Compose.ComposeBom))
    implementation(Dependencies.Compose.ComposeUI)
    implementation(Dependencies.Compose.ComposeMaterial)
    implementation(Dependencies.Compose.ComposeGraphics)

    implementation(Dependencies.Compose.ComposeUIToolingPrev)
    debugImplementation(Dependencies.Compose.ComposeUiTooling)

    androidTestImplementation(Dependencies.Compose.ComposeTest)
    debugImplementation(Dependencies.Compose.ComposeManifest)

    implementation(Dependencies.Compose.ComposeIconCore)
    implementation(Dependencies.Compose.ComposeIconExtended)
    implementation(Dependencies.Compose.ComposeWindow)

    implementation(Dependencies.Compose.ComposeActivity)
    implementation(Dependencies.Compose.CompseViewModel)
    implementation(Dependencies.Compose.ComposeLiveData)

    implementation(Dependencies.Compose.ComposeHilt)


}