package com.example.inputvalidations

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.inputvalidations.databinding.ActivityMainBinding
import com.example.inputvalidations.validator.EmailValidator
import com.example.inputvalidations.validator.EmptyValidator
import com.example.inputvalidations.validator.PasswordValidator
import com.example.inputvalidations.validator.base.BaseValidator
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val checkField: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkInputValidations()

    }

    private fun  checkInputValidations() {
        binding.buttonLogin.setOnClickListener {
            val username = binding.inputEditTextUsername.text.toString().trim()
            val email = binding.inputEditTextEmail.text.toString().trim()
            val password = binding.inputEditTextPassword.text.toString()

            val usernameEmptyValidation = EmptyValidator(username).validate()
            binding.inputLayoutUsername.error =
                if (!usernameEmptyValidation.isSussess)
                    getString(usernameEmptyValidation.message) else null

            val emailValidations = BaseValidator.validate(
                EmptyValidator(email), EmailValidator(email)
            )

            binding.inputLayoutEmail.error =
                if (!emailValidations.isSussess) getString(emailValidations.message) else null

            val passwordValidations = BaseValidator.validate(
                EmptyValidator(password), PasswordValidator(password)
            )

            binding.inputLayoutPassword.error =
                if (!passwordValidations.isSussess) getString(passwordValidations.message) else null

            //Show Snackbar if all field valid
            if (usernameEmptyValidation.isSussess && emailValidations.isSussess && passwordValidations.isSussess) {
                Snackbar.make(binding.root, "All field valid!", Snackbar.LENGTH_SHORT).show()
            }
        }

    }


}