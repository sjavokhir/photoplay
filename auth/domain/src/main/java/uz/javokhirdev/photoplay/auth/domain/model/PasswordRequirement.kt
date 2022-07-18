package uz.javokhirdev.photoplay.auth.domain.model

import androidx.annotation.StringRes
import uz.javokhirdev.photoplay.core.R

enum class PasswordRequirement(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digit),
    EIGHT_CHARACTERS(R.string.password_requirement_characters)
}