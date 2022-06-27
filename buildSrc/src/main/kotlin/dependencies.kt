object Libraries {
    const val KOIN_ANNOTATIONS_VERSION = "1.0.1"

    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:_"
    const val kotlinSerialize = "org.jetbrains.kotlinx:kotlinx-serialization-json:_"
    const val kotlinResult = "com.michael-bull.kotlin-result:kotlin-result:_"

    const val koinCore = "io.insert-koin:koin-android:_"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:_"
    const val koinAnnotations = "io.insert-koin:koin-annotations:$KOIN_ANNOTATIONS_VERSION"
    const val koinCompiler = "io.insert-koin:koin-ksp-compiler:$KOIN_ANNOTATIONS_VERSION"

    const val coreKtx = "androidx.core:core-ktx:_"
    const val dataStore = "androidx.datastore:datastore:_"
    const val splash = "androidx.core:core-splashscreen:_"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:_"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:_"
    const val livedataRuntime = "androidx.compose.runtime:runtime-livedata:_"
    const val appcompat = "androidx.appcompat:appcompat:_"
    const val material = "com.google.android.material:material:_"

    const val composeUi = "androidx.compose.ui:ui:_"
    const val composeActivity = "androidx.activity:activity-compose:_"
    const val composeFoundation = "androidx.compose.foundation:foundation:_"
    const val composeMaterial = "androidx.compose.material:material:_"
    const val composeIcons = "androidx.compose.material:material-icons-extended:_"
    const val composeCoil = "com.github.skydoves:landscapist-coil:_"
    const val composeTooling = "androidx.compose.ui:ui-tooling:_"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:_"

    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:_"
    const val composePlaceholder = "com.google.accompanist:accompanist-placeholder-material:_"

    const val mapsCore = "com.google.android.gms:play-services-maps:_"
    const val mapsKtx = "com.google.maps.android:maps-ktx:_"
    const val mapsCompose = "com.google.maps.android:maps-compose:_"
    const val mapsLocation = "com.google.android.gms:play-services-location:_"

    const val voyagerCore = "cafe.adriel.voyager:voyager-navigator:_"
    const val voyagerAndroid = "cafe.adriel.voyager:voyager-androidx:_"
    const val voyagerTabNavigation = "cafe.adriel.voyager:voyager-tab-navigator:_"
    const val voyagerTransitions = "cafe.adriel.voyager:voyager-transitions:_"

    const val coroutinesCore =   "org.jetbrains.kotlinx:kotlinx-coroutines-core:_"
    const val coroutinesAndroid =   "org.jetbrains.kotlinx:kotlinx-coroutines-android:_"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:_"

    const val hyperionCore = "com.willowtreeapps.hyperion:hyperion-core:_"
    const val hyperionPlugin = "com.willowtreeapps.hyperion:hyperion-plugin:_"
    const val hyperionCrash = "com.willowtreeapps.hyperion:hyperion-crash:_"
    const val hyperionPhoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:_"
    const val hyperionRecorder = "com.willowtreeapps.hyperion:hyperion-recorder:_"

    const val chuckerDebug = "com.github.chuckerteam.chucker:library:_"
    const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:_"

    const val retrofitCore = "com.squareup.retrofit2:retrofit:_"
    const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:_"
    const val moshiCore = "com.squareup.moshi:moshi:_"
    const val moshiKotlinCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:_"
    const val sqlDelightDriver = "com.squareup.sqldelight:android-driver:_"
    const val sqlDelightFlow = "com.squareup.sqldelight:coroutines-extensions-jvm:_"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:_"
    const val logcat = "com.squareup.logcat:logcat:_"

    const val store = "com.dropbox.mobile.store:store4:_"
    const val appAuth = "net.openid:appauth:_"

    const val junitJupiter = "org.junit.jupiter:junit-jupiter:_"
    const val kotest = "io.kotest:kotest-assertions-core:_"
    const val mockk = "io.mockk:mockk:_"
    const val turbine = "app.cash.turbine:turbine:_"

    const val autoServiceKsp = "dev.zacsweers.autoservice:auto-service-ksp:_"

    val Kotlin = setOf(kotlinReflect, kotlinSerialize, kotlinResult)
    val AndroidX = setOf(coreKtx, dataStore, lifecycle, livedata, livedataRuntime)
    val Koin = setOf(koinCore, koinCompose, koinAnnotations)
    val Voyager = setOf(voyagerCore, voyagerAndroid, voyagerTabNavigation, voyagerTransitions)
    val Compose = setOf(
        composeUi, composeTooling, composeToolingPreview, composeFoundation, composeMaterial,
        composeIcons, composePlaceholder, composeActivity, composeCoil
    )
    val Networking = setOf(retrofitCore, retrofitConverterMoshi, moshiCore, store)
    val Maps = setOf(mapsCore, mapsKtx, mapsCompose)
    val Coroutines = setOf(coroutinesCore, coroutinesAndroid)
    val SqlDelight = setOf(sqlDelightDriver, sqlDelightFlow)
    val Misc = setOf(appAuth, logcat)
    val Annotations = setOf(moshiKotlinCodeGen, koinCompiler, autoServiceKsp)

    val Debug = setOf(
        hyperionCore, hyperionCrash, hyperionRecorder,
        chuckerDebug, composeTooling, kotlinReflect
    )
    val Release = setOf(chuckerRelease)
    val Test = setOf(
        junitJupiter, kotest, mockk, coroutinesTest, turbine
    )
}
