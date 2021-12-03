package com.example.inputvalidations.validator.base

import com.example.inputvalidations.R

abstract class BaseValidator : IValidator {
    companion object {
        fun validate(vararg validators: IValidator) : ValidateResult {
            validators.forEach {
                val result = it.validate()
                if (!result.isSussess)
                    return result
            }
            return ValidateResult(true, R.string.text_validation_success)
        }
    }
}