package com.bottega.qdocnow.shared;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class IdComparatorInterceptor implements WebRequestInterceptor {
	@Override
	public void preHandle(WebRequest webRequest) throws Exception {
		String[] ids = webRequest.getParameterValues("id");
	}

	@Override
	public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

	}

	@Override
	public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

	}
}
