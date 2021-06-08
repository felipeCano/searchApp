package com.test.searchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvtest.text = "hey lord"

        Picasso.get()
            .load("https://i1.wp.com/codigoespagueti.com/wp-content/uploads/2021/02/Naruto-Cual-es-la-edad-de-Naruto-y-el-resto-del-Equipo-7.jpg?fit=1280%2C720&quality=80&ssl=1")
            .into(ivTest)
    }
}