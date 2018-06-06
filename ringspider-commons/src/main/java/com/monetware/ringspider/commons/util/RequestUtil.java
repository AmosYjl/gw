package com.monetware.ringspider.commons.util;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

/**
 * 
 * @author licc
 *
 */
public class RequestUtil {

	public static void logRequestMessage(Logger logger, HttpServletRequest request) {
		logger.info("ip=" + request.getRemoteAddr());
		logger.info(request.getRequestURI());
		logger.info("requestURL:" + request.getRequestURL());
		try {
			Map<String, String[]> params = request.getParameterMap();
			ArrayList<String> paramArr = new ArrayList<String>();
			for (String key : params.keySet()) {
				String[] values = params.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					paramArr.add(key + "=" + value);
				}
			}
			logger.info("requestParams: " + StringUtils.join(paramArr.toArray(), "&"));
		} catch (Exception e) {
			logger.error("error occured during getting request parameters from " + request.getRequestURL());
		}
		logger.info("---------------------");
	}
}
