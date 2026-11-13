package com.rafael.proffy.ui.forgot

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.rafael.proffy.R
import com.rafael.proffy.databinding.ActivityForgotBinding
import com.rafael.proffy.ui.finallyComponent.FinallyActivity

class ForgotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSendEmail.apply {
            isEnabled = false
            text = getString(R.string.forgot_btn_invalid)
            backgroundTintList = ColorStateList.valueOf(getColor(R.color.shape_disable))
            setTextColor(getColor(R.color.text_complement))
        }

        binding.buttonGoBack.setOnClickListener { finish() }
        binding.textInputEditEmail.addTextChangedListener { input ->
            val email = input?.toString()?.trim().orEmpty()
            val valid = isValidEmail(email)
            binding.textInputLayoutEmail.error = when {
                email.isBlank() || valid -> null
                else -> getString(R.string.forgot_error_invalid)
            }
            binding.buttonSendEmail.apply {
                isEnabled = valid
                text = getString(if (valid) R.string.forgot_btn_valid else R.string.forgot_btn_invalid)
                backgroundTintList = ColorStateList.valueOf(
                    getColor(if (valid) R.color.green else R.color.shape_disable)
                )
                setTextColor(getColor(if (valid) R.color.shape_01_white else R.color.text_complement))
            }
        }

        binding.buttonSendEmail.setOnClickListener {
            val email = binding.textInputEditEmail.text?.toString()?.trim().orEmpty()
            if (email.isBlank()) {
                binding.textInputLayoutEmail.error = getString(R.string.forgot_error_empty)
            } else if (isValidEmail(email)) {
                val intent = Intent(this, FinallyActivity::class.java).apply {
                    putExtra(FinallyActivity.EXTRA_TITLE, getString(R.string.forgot_finally_title))
                    putExtra(FinallyActivity.EXTRA_SUBTITLE, getString(R.string.forgot_finally_subtitle))
                    putExtra(FinallyActivity.EXTRA_BUTTON, getString(R.string.forgot_finally_btn))
                }
                startActivity(intent)
                finish()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean =
        email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
