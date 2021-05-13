package com.hertz.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * @author Hertz
 * @date 2021/5/10 15:19
 */
@Data
@Accessors(chain = true)
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    private CommonResult() {

    }

    public static <T> CommonResult<T> create(Integer code, String message, T data) {
        return new CommonResult<T>().setCode(code).setMessage(message).setData(data);
    }

    public static <T> CommonResult<T> create(Integer code, String message) {
        return new CommonResult<T>().setCode(code).setMessage(message);
    }

    public static <T> CommonResult<T> create(Integer code) {
        return new CommonResult<T>().setCode(code);
    }

    public static <T> CommonResult<T> create(Integer code, T data) {
        return new CommonResult<T>().setCode(code).setData(data);
    }

    public static <T> CommonResult<T> create(String message) {
        return new CommonResult<T>().setMessage(message);
    }

    public static <T> CommonResult<T> create() {
        return new CommonResult<>();
    }

    public static <T> CommonResult<T> create(Boolean success) {
        return create(200);
    }

    public static <T> CommonResult<T> create(Boolean success, T data) {
        if (success) {
            return create(200, data);
        } else {
            return create(500, data);
        }
    }

    public static <T> CommonResult<T> create(Boolean success, @NonNull String message, T data) {
        if (success) {
            return create(200, message + "成功", data);
        } else {
            return create(500, message + "失败", null);
        }
    }

}
