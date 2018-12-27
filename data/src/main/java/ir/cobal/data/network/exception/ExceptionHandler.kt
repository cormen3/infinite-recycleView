package ir.cobal.data.network.exception

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.HttpException
import org.json.JSONException
import org.json.JSONArray
import org.json.JSONObject

class ExceptionHandler{
    companion object {
        fun handleError(error: Throwable) : NetworkException {
            when (error) {
                is HttpException -> {
                    val errorBody = (error.response().errorBody()as ResponseBody).string()

                        if(errorBody.isNotEmpty() && isJSONValid(errorBody)){
                            return Gson().fromJson(errorBody, NetworkException::class.java)
                        }else {
                            return NetworkException("مشکل ارتباط با سرور")
                        }
                }
                is NetworkException ->
                        if(isJSONValid(error.message)){
                            var data = Gson().fromJson(error.message, NetworkException::class.java)
                            return  data
                        }else {
                            if(error.message.isNotEmpty()){
                                return NetworkException(error.message+ "  کد خطا : " + error.code)
                             }else {
                                 return NetworkException("مشکل ارتباط با سرور" + "  کد خطا : " + error.code)
                            }
                        }
                else ->{
                    return NetworkException("مشکل ارتباط با سرور")
                }
            }
        }

        private fun isJSONValid(test: String): Boolean {
            try {
                JSONObject(test)
            } catch (ex: JSONException) {
                try {
                    JSONArray(test)
                } catch (ex1: JSONException) {
                    return false
                }
            }
            return true
        }
    }
}