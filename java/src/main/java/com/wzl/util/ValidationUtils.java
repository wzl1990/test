/*
package com.wzl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

*/
/**
 * 参数验证工具类
 * 
 * @author zhenglong.wei
 * @since 18 十月 2017
 *
 *//*

public class ValidationUtils {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


	public static <T> ValidationResult validateEntity(T obj,Class<?> c) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validate(obj, c==null?Default.class:c);
		if (CollectionUtils.isNotEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	public static <T>  Boolean validateEntity(T obj) {
		Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
		if (CollectionUtils.isNotEmpty(set)) {
			List<String> errorMsg= Lists.newArrayList();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.add(cv.getMessage());
			}
			throw  new BizException(JSON.toJSONString(errorMsg));
		}
		return false;
	}


	public static <T> ValidationResult validateProperty(T obj, String propertyName) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, Default.class);
		if (CollectionUtils.isNotEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(propertyName, cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

}*/
