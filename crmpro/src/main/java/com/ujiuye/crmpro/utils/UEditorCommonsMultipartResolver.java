package com.ujiuye.crmpro.utils;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class UEditorCommonsMultipartResolver extends CommonsMultipartResolver {
	@Override
	public boolean isMultipart(HttpServletRequest request) {
		String url = request.getRequestURI();
		if (url != null && url.contains("/ueditor/init")) {
			return false;
		} else {
			return super.isMultipart(request);
		}
	}
}