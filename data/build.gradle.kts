import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugins.Path.AndroidLibrary)
    id(Plugins.Path.JetBrainKotlinAndroid)
    id(Plugins.NameTag.KotlinKAPT)
    id(Plugins.NameTag.DaggerHiltAndroid)
}

android {
    namespace = "com.kguard.data"
    compileSdk = AppConfig.CompileSdk

    defaultConfig {
        minSdk = AppConfig.MinSdk

        testInstrumentationRunner = AppConfig.TestInstrumentationRunner
        consumerProguardFiles(AppConfig.ConsumerProguardRules)

        buildConfigField("String","API_KEY", getApiKey("API_KEY"))
    }
    buildFeatures{
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

    implementation(Dependencies.AndroidX.CoreKtx)
    testImplementation(Dependencies.Test.Junit)
    androidTestImplementation(Dependencies.Test.TestExtJunit)
    androidTestImplementation(Dependencies.Test.TestEspressoCore)
    //lifecycle
    implementation(Dependencies.AndroidX.LifecycleViewModelKtx)
    implementation(Dependencies.AndroidX.LifecycleRuntimeKtx)
    implementation(Dependencies.AndroidX.LifecycleLivedataKtx)
    //Coroutines
    implementation(Dependencies.Coroutine.CoroutinesCore)
    implementation(Dependencies.Coroutine.CoroutinesAndroid)
    //DaggerHilt
    implementation(Dependencies.DaggerHilt.HiltAndroid)
    kapt(Dependencies.DaggerHilt.HiltAndroidCompiler)
    //retrofit
    implementation(Dependencies.Retrofit.Retrofit)
    implementation(Dependencies.Retrofit.RetrofitGsonConverter)
    //Okhttp
    implementation(Dependencies.Okhttp.Okhttp)
    implementation(Dependencies.Okhttp.LoggingInterceptor)
    implementation(Dependencies.Okhttp.UrlConnection)
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}