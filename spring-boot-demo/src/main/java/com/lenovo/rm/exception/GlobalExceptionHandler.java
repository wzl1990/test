package com.lenovo.rm.exception;

import com.lenovo.rm.dto.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class); 
	
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletResponse response, Exception e) throws Exception {
    	log.error("msg",e);
        response.sendRedirect("http://localhost:8080/angular/error.html");
    }
   
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResponseInfo jsonErrorHandler(HttpServletResponse response, MyException e) throws Exception {
    	response.setStatus( HttpStatus.INTERNAL_SERVER_ERROR.value());
    	log.error("jsonErrorHandler",e);
        return  new ResponseInfo(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "update success");
    }



    /**
     * 参数校验异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseInfo handleBindException(Exception ex) {
        log.error("参数异常", ex);
        StringBuilder sb=new StringBuilder();
        sb.append("参数异常   ");
        if(ex instanceof  BindException) {
            BindException e=(BindException)ex;
            if (e.hasGlobalErrors()) {
                for (ObjectError error : e.getGlobalErrors()) {
                    sb.append(error.getDefaultMessage()).append(",");
                }
            }
            if (e.hasFieldErrors()) {
                for (FieldError error : e.getFieldErrors()) {
                    sb.append(error.getField()).append(error.getDefaultMessage()).append("\n  ");
                }
            }
            return  new ResponseInfo(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), sb.toString());
        }else  if(ex instanceof  MethodArgumentNotValidException ){
            MethodArgumentNotValidException e=(MethodArgumentNotValidException)ex;
            BindingResult bindingResult = e.getBindingResult();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                sb.append(fieldError.getDefaultMessage()).append("\n  ");
            }
            return  new ResponseInfo(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), sb.toString());
        }else{
            return  new ResponseInfo(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");
        }
    }

    /**
     * 基于@ExceptionHandler异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseInfo exp( Exception e) {
        log.error("系统异常", e);
        return  new ResponseInfo(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");
    }
}

