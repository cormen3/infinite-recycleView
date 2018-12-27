package simra.androidtest.gheisary.twtest.utility.extensions

import android.arch.lifecycle.ViewModel
import android.widget.EditText
import com.google.gson.JsonObject


var JSON_KEY_USERNAME = "username"
var JSON_KEY_PASSWORD = "password"

fun ViewModel.createLoginJson(username:EditText, password:EditText): String{
    val jsonObject = JsonObject()
    jsonObject.addProperty(JSON_KEY_USERNAME,username.text.toString())
    jsonObject.addProperty(JSON_KEY_PASSWORD,password.text.toString())
    return jsonObject.toString()
}





