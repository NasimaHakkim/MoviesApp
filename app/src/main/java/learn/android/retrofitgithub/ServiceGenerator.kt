package learn.android.retrofitgithub

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by venu on 30-10-2017.
 */
class ServiceGenerator {

    companion object {

        private val BASE_URL = "https://api.themoviedb.org/3/"

        private val httpClient = OkHttpClient.Builder()


        private val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient!!.build())

        private var retrofit = builder.build()

        var logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        fun <S> createService(
                serviceClass: Class<S>): S {

            if(httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging)
                retrofit = builder.build()
            }
            return retrofit.create(serviceClass)
        }
    }
}