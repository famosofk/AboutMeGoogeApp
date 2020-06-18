package com.example.aboutmegoogleapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutmegoogleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Name using databinding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName


        button = binding.button
        button.setOnClickListener { view ->
            addNickname()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun addNickname() {
        button.visibility = View.GONE
        binding.myName!!.name = "Updated name"
        binding.myName!!.nickname = binding.nicknameEdit.text.toString()
        binding.apply {
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


    }
}