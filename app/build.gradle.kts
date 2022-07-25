plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    sourceSets {
        getByName("main") {
            assets {
                srcDirs("src/main/assets")
            }
        }
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.authPresentation))
    implementation(project(Modules.authDomain))
    implementation(project(Modules.authData))
    implementation(project(Modules.homePresentation))
    implementation(project(Modules.homeDomain))
    implementation(project(Modules.homeData))
    implementation(project(Modules.profilePresentation))
    implementation(project(Modules.profileDomain))
    implementation(project(Modules.profileData))
    implementation(project(Modules.downloadsPresentation))
    implementation(project(Modules.downloadsDomain))
    implementation(project(Modules.downloadsData))
    implementation(project(Modules.movieDetailPresentation))
    implementation(project(Modules.movieDetailDomain))
    implementation(project(Modules.movieDetailData))

    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.icons)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.material)
    implementation(Compose.runtime)
    implementation(Compose.navigation)
    implementation(Compose.viewModelCompose)
    implementation(Compose.activityCompose)

    implementation(Android.coreKtx)
    implementation(Android.appCompat)

    implementation(Google.material)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    implementation(Coil.coilCompose)
}