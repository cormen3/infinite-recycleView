package simra.androidtest.gheisary.twtest.utility.extensions

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText
import java.util.regex.Pattern

fun String.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPhoneNumber(): Boolean = PHONE_NUMBER.matcher(this).matches()

fun String.isValidMobileNumber(): Boolean = this.isNotEmpty() && PHONE_NUMBER.matcher(this).matches()
fun EditText.isValidMobileNumber(): Boolean = this.text.isNotEmpty() && PHONE_NUMBER.matcher(this.text).matches()

fun String.isValidVerificationCode(): Boolean = this.isNotEmpty() && this.length == 5
fun EditText.isValidVerificationCode(): Boolean = this.text.isNotEmpty() && this.text.length == 5

fun String.isValidPassword(): Boolean = this.isNotEmpty() && this.length > 3


    val PHONE_NUMBER = Pattern.compile(

            "^[0][9][0-9]{9,9}\$"
)

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
    })
}

fun EditText.validate(validator: (String) -> Boolean, message: String) {
    this.afterTextChanged {
        this.error = if (validator(it)) null else message
    }
    this.error = if (validator(this.text.toString())) null else message
}

fun EditText.isFilled():Boolean {
   return this.text.toString().isNotEmpty()
}

