
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.linked.game"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.linked.game"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }

    sourceSets {
        getByName("main") {
            assets.srcDirs("../core/src/main/assets")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core"))

    implementation("com.badlogicgames.gdx:gdx:1.13.1")
    implementation("com.badlogicgames.gdx:gdx-backend-android:1.13.1")

    runtimeOnly(
        "com.badlogicgames.gdx:gdx-platform:1.13.1:natives-armeabi-v7a"
    )
    runtimeOnly(
        "com.badlogicgames.gdx:gdx-platform:1.13.1:natives-arm64-v8a"
    )
}
