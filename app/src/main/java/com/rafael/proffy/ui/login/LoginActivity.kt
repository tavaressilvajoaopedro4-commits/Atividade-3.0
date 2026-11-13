package com.rafael.proffy.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafael.proffy.databinding.ActivityLoginBinding
import com.rafael.proffy.ui.forgot.ForgotActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonForgot.setOnClickListener {
            startActivity(Intent(this, ForgotActivity::class.java))
        }
    }
}
