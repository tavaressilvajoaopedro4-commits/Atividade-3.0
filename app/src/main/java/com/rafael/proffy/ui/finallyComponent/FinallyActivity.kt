package com.rafael.proffy.ui.finallyComponent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafael.proffy.R
import com.rafael.proffy.databinding.ActivityFinallyBinding
import com.rafael.proffy.ui.login.LoginActivity

class FinallyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinallyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinallyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewTitleFinally.text = intent.getStringExtra(EXTRA_TITLE)
            ?: getString(R.string.forgot_finally_title)
        binding.textViewSubtitle.text = intent.getStringExtra(EXTRA_SUBTITLE)
            ?: getString(R.string.forgot_finally_subtitle)
        binding.buttonGoToLogin.text = intent.getStringExtra(EXTRA_BUTTON)
            ?: getString(R.string.forgot_finally_btn)

        binding.buttonGoToLogin.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(loginIntent)
            finish()
        }
    }

    companion object {
        const val EXTRA_TITLE = "textViewTitleFinally"
        const val EXTRA_SUBTITLE = "textViewSubtitleFinally"
        const val EXTRA_BUTTON = "titleButton"
    }
}
