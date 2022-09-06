import org.gradle.api.JavaVersion

object Versions {
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32

    const val jvmTarget = "1.8"
    val java = JavaVersion.VERSION_1_8

    // Android X
    const val coreKtx = "1.8.0"
    const val lifecycle = "2.4.1"
    const val navigation = "2.5.0-alpha02"
    const val splashScreen = "1.0.0-beta01"

    // Google
    const val material = "1.6.1"
    const val flexBox = "3.0.0"

    // Koin
    const val koin = "2.2.3"

    // Retrofit
    const val retrofit = "2.9.0"

    // OkHttp
    const val okhttp = "4.6.0"

    // Test
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"

}