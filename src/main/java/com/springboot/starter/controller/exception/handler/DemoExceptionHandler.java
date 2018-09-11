package com.springboot.starter.controller.exception.handler;

import com.springboot.starter.consts.GlobalConst;
import com.springboot.starter.exception.DemoException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DemoExceptionHandler {

    private final static String DEMO_EXCEPTION = "出现自定义异常了！";
    private final static String RUNTIME_EXCEPTION = "出现运行时异常了！";
    private final static String EXCEPTION = "出现未知异常了！";

    @ExceptionHandler(DemoException.class)
    @ResponseBody
    public Map<String, Object> demoExceptionHandler() {
        Map<String, Object> result = new HashMap<>();
        result.put(GlobalConst.ERROR_CODE, 10001);
        result.put(GlobalConst.ERROR_MSG, DEMO_EXCEPTION);
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> runtimeExceptionHandler() {
        Map<String, Object> result = new HashMap<>();
        result.put(GlobalConst.ERROR_CODE, 10002);
        result.put(GlobalConst.ERROR_MSG, RUNTIME_EXCEPTION);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler() {
        Map<String, Object> result = new HashMap<>();
        result.put(GlobalConst.ERROR_CODE, 10004);
        result.put(GlobalConst.ERROR_MSG, EXCEPTION);
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        Map<String, Object> result = new HashMap<>();
        result.put(GlobalConst.ERROR_CODE, 10003);
        result.put(GlobalConst.ERROR_MSG, fieldError.getDefaultMessage());
        return result;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String, Object> bindExceptionHandler(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        Map<String, Object> result = new HashMap<>();
        result.put(GlobalConst.ERROR_CODE, 10005);
        result.put(GlobalConst.ERROR_MSG, fieldError.getDefaultMessage());
        return result;
    }
}
