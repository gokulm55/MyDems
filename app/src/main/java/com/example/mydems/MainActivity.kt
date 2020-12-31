package com.example.mydems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.example.mydems.dataclass.ApiClient

import com.example.mydems.dataclass.profile

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var email:EditText
    lateinit var phone:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.name)
        email=findViewById(R.id.email)
        phone=findViewById(R.id.phone)
       getDatas()
    }
    private fun getDatas() {
         try {
            val call: Call<profile> = ApiClient.getClient.getDetails()
            call.enqueue(object : Callback<profile> {
                override fun onResponse(call: Call<profile>?, response: Response<profile>?) {
//                    val body = response!!.body()!!.data
                    Log.e("sucess", "" +response)
                    Log.e("dataname",""+ response!!.body()!!.data.name)
                    Log.e("image",""+response.body()!!.data.profile_pic)

                }

                override fun onFailure(call: Call<profile>?, t: Throwable?) {
                    Log.e("failure",""+t!!.message)
                }

            })
        }catch (e:Exception)
        {
            Log.e("catch",""+e)
        }

    }

}

