package com.example.inputvalidations.validator

import com.example.inputvalidations.R
import com.example.inputvalidations.validator.base.BaseValidator
import com.example.inputvalidations.validator.base.ValidateResult

class PasswordValidator (val password : String) : BaseValidator() {
    private val minPasswordLength = 6
    private val maxPasswordLength = 25

    override fun validate(): ValidateResult {
        if (password.length < minPasswordLength)
            return ValidateResult(false, R.string.text_validation_error_min_pass_length)
        if (password.length > maxPasswordLength)
            return ValidateResult(false, R.string.text_validation_error_max_pass_length)
        return ValidateResult(true, R.string.text_validation_success)
    }
}