package com.rupinder.customalertdialog

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rupinder.customalertdialog.databinding.ActivityMainBinding
import com.rupinder.customalertdialog.databinding.ActivitySecondBinding
import com.rupinder.customalertdialog.databinding.Customdialog1Binding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnENTER.setOnClickListener {
       var intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}