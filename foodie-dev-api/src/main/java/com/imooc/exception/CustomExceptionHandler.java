package com.imooc.exception;

import com.imooc.utils.IMOOCJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
/**
 * 上传文件超过500k捕获异常
 */
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public IMOOCJSONResult handleMaxUploadFile(MaxUploadSizeExceededException exception) {
        return IMOOCJSONResult.errorMsg("大小不能超过500k");
    }
}
