package es.begeek.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.StringConverter;

public class Converter {

	public static Object convertDTOToEntity(Object dto, Object entity){
		try {
			DateConverter dateConverter = new DateConverter(null);
			dateConverter.setPattern("dd/MM/yyyy HH:mm");
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(dateConverter, Date.class);
			beanUtilsBean.getConvertUtils().register(new LongConverter(null), Long.class);
			beanUtilsBean.getConvertUtils().register(new StringConverter(null), String.class);
			beanUtilsBean.copyProperties(entity,dto);
			return entity;
		} catch (IllegalAccessException | InvocationTargetException e) {
			return null;
		}
	}
	public static Object convertEntityToDTO(Object entity, Object dto){
		try {
			DateConverter dateConverter = new DateConverter(null);
			dateConverter.setPattern("dd/MM/yyyy HH:mm");
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(dateConverter, Date.class);
			beanUtilsBean.getConvertUtils().register(new StringConverter(null), String.class);
			beanUtilsBean.copyProperties(dto,entity);
			return dto;
		} catch (IllegalAccessException | InvocationTargetException e) {
			return null;
		}
	}
	
}
