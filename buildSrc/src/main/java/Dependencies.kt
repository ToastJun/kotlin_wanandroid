object Versions {
    const val androidPlugins = "3.5.3"
    const val fragmentNav = "2.3.0-alpha01"

    const val kotlin = "1.3.61"
    const val kodein = "6.5.0"

    const val appcompat = "1.1.0"
    const val constraintlayout = "1.1.3"
    const val material = "1.1.0"
    const val coreKtx = "1.2.0"

    // jetpack
    const val lifecycleExtensions = "2.2.0"
    const val lifecycleLivedata = "2.2.0"
    const val lifecycleViewModel = "2.2.0"
    const val navigationFragment = "2.2.0"
    const val navigationUi = "2.2.0"
    const val room = "2.1.0"
    const val work = "2.1.0"
    const val glide = "4.10.0"
    const val gson = "2.8.2"

    const val retrofit = "2.7.1"
    const val okhttp = "4.3.0"
}

object BuildVersions {
    const val compileSdkVersion = 29
    const val buildToolsVersion = "29.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildPlugins {
    const val androidPlugins = "com.android.tools.build:gradle:${Versions.androidPlugins}"
    const val kotlinPlugins = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafeArgsPlugins = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.fragmentNav}"
}

object Dependencies {

    const val kotlinStdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val logger = "com.orhanobut:logger:2.2.0"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedata}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragment}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUi}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val work = "androidx.work:work-runtime-ktx:${Versions.work}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val kodeinDiJvm = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
    const val kodeinDiCore = "org.kodein.di:kodein-di-framework-android-core:${Versions.kodein}"
    const val kodeinDiAndroidX = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"

    const val smartrefresh = "com.scwang.smartrefresh:SmartRefreshLayout:1.1.2"

    const val junit = "junit:junit:4.12"
    const val androidJunit = "androidx.test.ext:junit:1.1.1"
    const val androidTestEspresso = "androidx.test.espresso:espresso-core:3.2.0"

    const val loadSir = "com.kingja.loadsir:loadsir:1.3.8"

    const val cookieJar = "com.github.franmontiel:PersistentCookieJar:v1.0.1"

    const val mmkv = "com.tencent:mmkv-static:1.2.1"

    const val adapterHelper = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4"
}