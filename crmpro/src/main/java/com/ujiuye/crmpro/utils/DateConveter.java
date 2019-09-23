package com.ujiuye.crmpro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConveter implements Converter<String, Date> {

	@Override
	public Date convert(String createtime) {
		SimpleDateFormat simpleDateFormat = null;
		
		if (createtime.contains("/")) {
			simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		} else {
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
		
		try {
			return simpleDateFormat.parse(createtime);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;

		
	}

}
