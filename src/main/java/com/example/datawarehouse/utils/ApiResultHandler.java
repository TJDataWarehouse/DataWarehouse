package com.example.datawarehouse.utils;

public class ApiResultHandler {

//    public static ApiResult success(Object object) {
//        ApiResult apiResult = new ApiResult();
//        apiResult.setData(object);
//        apiResult.setCode(200);
//        apiResult.setMessage("请求成功");
//        return apiResult;
//    }

    public static ApiResult buildApiResult(long runTime, Integer code, String message, Object data) {
        ApiResult apiResult = new ApiResult();

        apiResult.setRunTime(runTime);
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }
}
