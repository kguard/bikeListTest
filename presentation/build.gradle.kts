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
    implementation(Dependencies.Kotlin.CoroutinesCore)
    implementation(Dependencies.Kotlin.CoroutinesAndroid)
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

}