package com.example.inputvalidations.validator

import android.text.TextUtils
import com.example.inputvalidations.R
import com.example.inputvalidations.validator.base.BaseValidator
import com.example.inputvalidations.validator.base.ValidateResult

class EmailValidator (val email : String) : BaseValidator() {
    override fun validate(): ValidateResult {
        val isValid =
            !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        return ValidateResult(
            isValid,
            if (isValid) R.string.text_validation_success
        else R.string.text_validation_error_email
        )
    }
}