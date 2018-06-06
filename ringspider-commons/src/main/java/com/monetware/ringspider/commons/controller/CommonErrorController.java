package com.monetware.ringspider.commons.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.monetware.ringspider.commons.util.JsonResult;

/**
 * 
 * @author licc
 *
 */
@Controller
@RequestMapping("/error")
public class CommonErrorController implements ErrorController {

	private ErrorAttributes errorAttributes;

	@Autowired
	private ServerProperties serverProperties;

	@Autowired
	public CommonErrorController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping(produces = "text/html")
	public ModelAndView errorHtml404(HttpServletRequest request, HttpServletResponse response) {
		Integer status = getStatus(request).value();
		
		String message = "";
		switch(status) {
		case 401: message = "您的权限不足以访问相关页面，请联系管理员"; break;
		case 404: message = "您要访问的页面不存在"; break;
		case 500: message = "服务器异常，请联系客服人员!"; break;
		default: message = "未知错误"; break;
		}
		
		Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		model.put("message", message);
		return new ModelAndView("error/error", model);
	}
	
	/**
	 * ajax请求时，返回json数据
	 * @param request
	 * @return
	 */
	@RequestMapping
    @ResponseBody
    public JsonResult error404(HttpServletRequest request) {
		Integer status = getStatus(request).value();
		
		String message = "";
		switch(status) {
		case 401: message = "您的权限不足以访问相关页面，请联系管理员"; break;
		case 404: message = "您要访问的页面不存在"; break;
		case 500: message = "服务器内部错误"; break;
		default: message = "未知错误"; break;
		}
		
        Map<String, Object> attributes = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML));
        
        return new JsonResult(false, message, attributes);
    }

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
	}

	protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
		ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
		if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
			return true;
		}
		if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
			return getTraceParameter(request);
		}
		return false;
	}

	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}

	@Override
	public String getErrorPath() {
		return null;
	}

}
