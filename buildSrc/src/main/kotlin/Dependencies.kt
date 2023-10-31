object Dependencies {
    object AndroidX {
        private const val NAVIGATION_VERSION = "2.6.0"
        private const val VIEW_MODEL_VERSION = "2.6.1"
        private const val VIEW_KTX_VERSION = "1.6.1"

        const val CoreKtx = "androidx.core:core-ktx:1.12.0"
        const val Appcompat = "androidx.appcompat:appcompat:1.6.1"
        const val Constraintlayout ="androidx.constraintlayout:constraintlayout:2.1.4"

        const val LifecycleViewModelKtx= "androidx.lifecycle:lifecycle-viewmodel-ktx:$VIEW_MODEL_VERSION"
        const val LifecycleRuntimeKtx= "androidx.lifecycle:lifecycle-runtime-ktx:$VIEW_MODEL_VERSION"
        const val LifecycleLivedataKtx= "androidx.lifecycle:lifecycle-livedata-ktx:$VIEW_MODEL_VERSION"

        const val FragmentKtx = "androidx.fragment:fragment-ktx:$VIEW_KTX_VERSION"
        const val ActivityKtx = "androidx.activity:activity-ktx:$VIEW_KTX_VERSION"

        const val NavigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
        const val NavigationUiKtx = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"


    }
    object Kotlin{
        private const val COROUTINES_VERSION = "1.6.4"
        const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
        const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"

    }
    object Compose{
        //private const val COMPOSE_VERSION= "1.5.2"
        const val ComposeBom = "androidx.compose:compose-bom:2023.10.01"
        const val ComposeMaterial = "androidx.compose.material3:material3"
        const val ComposeUI = "androidx.compose.ui:ui"
        const val ComposeGraphics ="androidx.compose.ui:ui-graphics"
        // Android Studio Preview support
        const val ComposeUiTooling = "androidx.compose.ui:ui-tooling"
        const val ComposeUIToolingPrev = "androidx.compose.ui:ui-tooling-preview"
        // UI Tests
        const val ComposeTest = "androidx.compose.ui:ui-test-junit4"
        const val ComposeManifest = "androidx.compose.ui:ui-test-manifest"


        const val ComposeIconCore= "androidx.compose.material:material-icons-core"
        // Optional - Add full set of material icons
        const val ComposeIconExtended= "androidx.compose.material:material-icons-extended"
        // Optional - Add window size utils
        const val ComposeWindow= "androidx.compose.material3:material3-window-size-class"

        // Optional - Integration with activities
        const val ComposeActivity= "androidx.activity:activity-compose:1.8.0"
        // Optional - Integration with ViewModels
        const val CompseViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2"
        // Optional - Integration with LiveData
        const val ComposeLiveData = "androidx.compose.runtime:runtime-livedata"



    }
    object Google {
        const val AndroidMaterial = "com.google.android.material:material:1.9.0"
    }
    object Test {
        private const val JUNIT_VERSION = "4.13.2"
        private const val TEST_EXT_JUNIT_VERSION = "1.1.5"
        private const val TEST_ESPRESSO_CORE_VERSION = "3.5.1"

        const val Junit = "junit:junit:$JUNIT_VERSION"
        const val TestExtJunit = "androidx.test.ext:junit:$TEST_EXT_JUNIT_VERSION"
        const val TestEspressoCore = "androidx.test.espresso:espresso-core:$TEST_ESPRESSO_CORE_VERSION"
    }
    object DaggerHilt{
        private const val HILT_VERSION = "2.46.1"
        const val HiltAndroid= "com.google.dagger:hilt-android:$HILT_VERSION"
        const val HiltCompiler= "com.google.dagger:hilt-compiler:$HILT_VERSION"
        const val HiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"
    }
    object Retrofit{
        private const val RETROFIT_VERSION = "2.9.0"
        const val Retrofit = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
        const val RetrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"
    }
    object Okhttp{
        const val Okhttp = "com.squareup.okhttp3:okhttp:4.9.3"
        const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3"
        const val UrlConnection = "com.squareup.okhttp3:okhttp-urlconnection:3.14.9"
    }


}