plugins {
    id(Plugins.NameTag.KotlinKAPT)
    id(Plugins.NameTag.KotlinJvm)
}

dependencies {
    implementation(Dependencies.Kotlin.CoroutinesCore)
    implementation(Dependencies.Kotlin.CoroutinesAndroid)
}