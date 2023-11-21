plugins {
    id(Plugins.NameTag.KotlinKAPT)
    id(Plugins.NameTag.KotlinJvm)
}

dependencies {
    implementation(Dependencies.Coroutine.CoroutinesCore)
    implementation(Dependencies.Coroutine.CoroutinesAndroid)
}