package com.example.inputvalidations.validator

import com.example.inputvalidations.R
import com.example.inputvalidations.validator.base.BaseValidator
import com.example.inputvalidations.validator.base.ValidateResult

class EmptyValidator (val input : String) : BaseValidator() {
    override fun validate(): ValidateResult {
        val isValid = input.isNotBlank()
        return ValidateResult(
            isValid,
            if (isValid) R.string.text_validation_success
        else R.string.text_validation_error_empty_field
        )
    }
}