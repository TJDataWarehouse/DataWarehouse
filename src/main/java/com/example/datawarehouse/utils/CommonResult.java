package com.example.datawarehouse.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommonResult<T> {
    //状态码,example = "200")
    long code;
    //状态信息,example = "操作成功"
    String message;
    //返回数据
    T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * 成功返回结果
     * @param code 成功码
     * @param message 成功信息
     * @param data 数据
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(long code, String message, T data){
        return new CommonResult<>(code,message,data);
    }

    /**
     * 成功返回结果
     * @param message 成功信息
     * @param data 数据
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(String message,T data){
        return success(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 成功返回结果
     * @param data 成功信息
     * @param <T> 成功返回类型
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return success(ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param <T> 返回类型
     * @return
     */
    public static <T> CommonResult<T> success(){
        return success(null);
    }

    /**
     * 失败返回结果
     * @param code 失败码
     * @param message 失败信息
     * @param data 数据
     * @param <T> 返回类型
     * @return
     */
    public static <T> CommonResult<T> failed(long code,String message,T data){
        return new CommonResult<>(code,message,data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,String message) {
        return new CommonResult<>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message,T data) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 失败返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(T data){
        return new CommonResult<>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),data);
    }

    @Override
    public String toString() {
        return "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data ;
    }
}
