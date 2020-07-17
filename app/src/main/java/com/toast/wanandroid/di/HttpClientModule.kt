package com.toast.wanandroid.di

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.toast.wanandroid.BuildConfig
import com.toast.wanandroid.base.ToastApp
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import java.security.cert.CertificateException

/**
 * @author toast
 * @date 2020/4/23 10:52
 * @description
 */

private const val HTTP_CLIENT_MODULE_TAG = "httpClientModule"
const val HTTP_CLIENT_MODULE_INTERCEPTOR_LOG_TAG = "http_client_module_interceptor_log_tag"
const val HTTP_CLIENT_MODULE_INTERCEPTOR_AUTH_TAG = "http_client_module_interceptor_auth_tag"

const val TIME_OUT_SECONDS = 30
const val BASE_URL = "https://www.wanandroid.com"

val httpClientModule = Kodein.Module(HTTP_CLIENT_MODULE_TAG, init = {

    bind<Retrofit.Builder>() with provider { Retrofit.Builder() }

    bind<OkHttpClient.Builder>() with provider { OkHttpClient.Builder() }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl(BASE_URL)
            .client(instance())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    bind<Interceptor>(HTTP_CLIENT_MODULE_INTERCEPTOR_LOG_TAG) with singleton {
        HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>()
            .connectTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .cookieJar(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(ToastApp.INSTANCE)))    // 添加 cookie 缓存
            .addInterceptor(instance<Interceptor>(HTTP_CLIENT_MODULE_INTERCEPTOR_LOG_TAG))
                // 忽略 SSL安全证书 调试时用于抓包使用
            .sslSocketFactory(getSSLFactory(), object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }

                @Throws(CertificateException::class)
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }
            })
            .hostnameVerifier(object : HostnameVerifier{
                override fun verify(hostname: String?, session: SSLSession?): Boolean {
                    return true
                }
            })
            .build()
    }


})

fun getSSLFactory(): SSLSocketFactory {
    //         Create a trust manager that does not validate certificate chains
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }

        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        }
    })

    // Install the all-trusting trust manager
    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, SecureRandom())
    // Create an ssl socket factory with our all-trusting manager
    return sslContext.socketFactory
}