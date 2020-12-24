package com.example.mydems.dataclass

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object ApiClient
{
    var BASE_URL:String="http://dems.darashmaju.com/"
    val getClient: ApiInterface
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(object: Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain:Interceptor.Chain): Response {
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header("User-Agent", "mydems")
                        .header("Accept", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjUzYWZkMDVhMWQxZDVmYTMwYzc2MzAyOWZkNDljMTRkMDIzNzM4ZmMwZjNlMjdiYjMzMzMwNTIwM2Q0MzA3MzFmYmY4MjA5Y2I0YzhmNzIyIn0.eyJhdWQiOiIxIiwianRpIjoiNTNhZmQwNWExZDFkNWZhMzBjNzYzMDI5ZmQ0OWMxNGQwMjM3MzhmYzBmM2UyN2JiMzMzMzA1MjAzZDQzMDczMWZiZjgyMDljYjRjOGY3MjIiLCJpYXQiOjE2MDg4MDE1NzIsIm5iZiI6MTYwODgwMTU3MiwiZXhwIjoxNjQwMzM3NTcyLCJzdWIiOiIzOCIsInNjb3BlcyI6W119.kshEYeT7PPDrzq4zD862vm7nwjv4kWFp_QJI39LmzqW2iMUMJT03cTz96st8WHlqZxGacj6vGaLgpnSLuB3ycBzUBh8fjNYv-dg8hefmkJ6_9iRDs624qHjcAiEi0UgzA3IkZ8PGj71CaYBxPO4R8-q9D_FzllaTIOP5aarRlK7_oUJ6L7f_OL6LeobeTeH3PqL7bvmZMwS_MYRLYPGzdO3fcTkHDexCqMauN3QQdIiOAO-Z6CNHAszTESbcCvLbVeVZqXqLEWFrzswbioi1xs74HdZS6mFB1jxt-iDwAfceoQAU2hR_vSM6K3IeWTDguDDi1mF6ItOiQP7nbokUw1O0roTlOwuCQfd6WidVegvEfqiHT67cnegaLG1kBYepxv3mMSD87JJrpA6ca8W37Ms2IPZtNJe39Km6iJlyFtP1Kiy0C6aQRukzR9OeugDT5lxMx9GsQeGTgegv4Myi4zwGTn8QxMe-OSZ4SdrohRNJeAYOCTuIwzwLPeNpFNjDy6AO6u6N5_3HOQUDVLMZYUvmqC7LXcAK6yDzuhT6Hn31Zb7HxGEiMe9wV1zdpVx1s208UyPzenGorf84f4gOMsVIYHrCKHdtdM0n_FoYi1w1RIcFMvCcV8nxkkyTI3r6s1JbJDCOF2egGFpXcpesU7jYMpt5-xcD0qxocm2AP0A")
                        .method(original.method(), original.body())
                        .build()
                    return chain.proceed(request)
                }
            })

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiInterface::class.java)

        }
}