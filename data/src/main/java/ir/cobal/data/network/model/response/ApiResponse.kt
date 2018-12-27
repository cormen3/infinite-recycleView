package ir.cobal.data.network.model.response

import java.util.ArrayList

class ApiResponse<T>(var succeed:Boolean, var errors: ArrayList<ErrorCode>, var data:T)