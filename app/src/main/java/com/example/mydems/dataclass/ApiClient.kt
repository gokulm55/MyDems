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
            val client = OkHttpClient.Builder().addInterceptor(object: Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain:Interceptor.Chain): Response {
                    val original = chain.request()
                    val request = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImNkYmM3MjE4NzdlYTU0ZTk5MWEwMjZlZDI3YWVlZDMwZWYyZTAzZjMwMmViYjkzNmFhN2NmMzNjYjc1YjA3ZTg5NWJlOWMzYmNiZGNiZTNiIn0.eyJhdWQiOiIxIiwianRpIjoiY2RiYzcyMTg3N2VhNTRlOTkxYTAyNmVkMjdhZWVkMzBlZjJlMDNmMzAyZWJiOTM2YWE3Y2YzM2NiNzViMDdlODk1YmU5YzNiY2JkY2JlM2IiLCJpYXQiOjE2MDg4MTYyMTMsIm5iZiI6MTYwODgxNjIxMywiZXhwIjoxNjQwMzUyMjEzLCJzdWIiOiI0MCIsInNjb3BlcyI6W119.ygwTweU5791de_oak2sXCGJb7dZRUGs_bARHXAdKwnGx8S7IVJNR1ZNRkHeo4xQ_xrbXH1Ia6-42SRZvmkYoxzqk26N3FkH2SP8KA527_hfwasxG1LT88LVAow_KXNQ7_U8yuuTKJBrZP0G-kPk6InsZz9eVAnaltkRduI_W-I6ROzZ0C7TxsRUc5xeq3VjLByoSvwu760KPu8-4ZkFNFRk9QijzbosqSEqM9XPmL6ILM3ig7ApS82a01qFEkijKAbS430Yjuw-UDnBnkuIXLUYeVAovS3Ajq54zv0pqheGoU5CIYGZRjnJNDW-30ehieB6HPBHnpcdDbw_blvJxDzfxpvLosQ7cCjGotQ1G1oxujPcpQk1UrF6GjsVpvH2ZaGiGLVpOA4_ZwRJr0_xKqGpBd5VKPll7Zm0hoTmROZ3w46iqYI34ofJK6OafUcxanNt-4nIT7QL3YdA8_zv1H2N2DGmhpuu3MzKSq4Dm5LhWeAhYIRheSTSgwY6PCCcvt2877qrNGgBZ5eV2bthv9_XVxdQfJ4O9-bD72Vn2r-ARf4boxow3cvb3qM8GtSSRdGVtfHNdsobHD4Z32lLbMEoCHcFm1EKv9G2KLhXeZKkCdsqasSc4Kfyw7JsrRNn9bTOqLHJGJGkG7kDB6TnqaHAZKWYmNOlHt6KCiuULsR8")
                        .build()
                    return chain.proceed(request)
                }
            }).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiInterface::class.java)

        }
}