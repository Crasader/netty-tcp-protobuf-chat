package com.funstill.netty.chat.common.exception.handler;

import com.funstill.netty.chat.common.api.ResultCode;
import com.funstill.netty.chat.common.api.impl.DefaultResultCode;
import com.funstill.netty.chat.common.exception.CommonException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;



/**
 * 
 * 使用示例1:产生异常后默认进入jsonErr模版,如需进入htmlErr模版则在controller中添加HtmlRequired注解
 * <pre>
 * <bean id="simpleMappingExceptionResolver" class="com.funstill.msf.common.exception.handler.HandleExceptionResolver">
        <property name="classes">
            <list value-type="java.lang.Class[]">
                <value type="java.lang.Class">com.funstill.msf.common.annotation.ResponseHtml</value>
            </list>
        </property>
        <property name="annotationErrorView" value="exception/htmlErr"/>
        <property name="defaultErrorView" value="exception/jsonErr"/>
        <property name="order" value="0" /> 
    </bean>
 * </pre>
 * 
 * 使用示例2:默认进入htmlErr模版
 * <pre>
 	<bean id="simpleMappingExceptionResolver" class="com.funstill.msf.common.exception.handler.HandleExceptionResolver">
        <property name="classes">
            <list value-type="java.lang.Class[]">
                <value type="java.lang.Class">com.funstill.msf.common.annotation.ResponseJson</value>
                <value type="java.lang.Class">org.springframework.web.bind.annotation.ResponseBody</value>
            </list>
        </property>
        <property name="annotationErrorView" value="exception/jsonErr"/>
        <property name="defaultErrorView" value="exception/htmlErr"/>
        <property name="order" value="0" /> 
    </bean>
 * </pre>
 * 
 */
public class HandleExceptionResolver extends SimpleMappingExceptionResolver {

	private Logger logger = LogManager.getLogger(HandleExceptionResolver.class);

	private String annotationErrorView;
	
	private Class<Annotation>[] classes;

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// Expose ModelAndView for chosen error view.
	
		ResultCode resultCode;

		if (ex instanceof CommonException) {
			CommonException commonException = (CommonException) ex;
			if (commonException.getResultCode() != null) {
				resultCode = commonException.getResultCode();
			} else {
				resultCode = DefaultResultCode.SYSTEM_ERROR_UNKOWN;
				resultCode.setMsg(commonException.getMessage());
			}
		} else if (ex instanceof DataAccessException) {
			resultCode = DefaultResultCode.SYSTEM_ERROR_DAO;
		} else if (ex instanceof RuntimeException) {
			resultCode = DefaultResultCode.SYSTEM_ERROR_UNKOWN;
		} else if (ex instanceof MissingServletRequestParameterException) {
			resultCode = DefaultResultCode.ILLEGAL_ARGUMENT;
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			resultCode = DefaultResultCode.REQUEST_ERROR_INVALID_METHOD;
		} else if (ex instanceof BindException) { // spring接收参数异常
			resultCode = DefaultResultCode.ILLEGAL_ARGUMENT;
		} else {
			resultCode = DefaultResultCode.SYSTEM_ERROR_UNKOWN;
		}
		logger.error(ex);
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			
			// Apply HTTP status code for error views, if specified.
			// Only apply it if we're processing a top-level request.
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			ModelAndView mv =null;
			if (handler instanceof HandlerMethod
					&& hasAnnotation((HandlerMethod) handler, classes)) {
				mv = getModelAndView(annotationErrorView, ex, request);
				mv.addObject("result", resultCode);
			}else{
				mv = getModelAndView(viewName, ex, request);
				mv.addObject("result", resultCode);
			}
			return mv;
		} else {
			return null;
		}
	}

	@SafeVarargs
	private final boolean hasAnnotation(HandlerMethod handlerMethod, 
			Class<? extends Annotation>... annotations) {
		for (Class<? extends Annotation> annotation : annotations) {
			if (handlerMethod.getMethod().isAnnotationPresent(annotation)
					|| handlerMethod.getBean().getClass().isAnnotationPresent(annotation)) {
				return true;
			}
		}
		return false;
	}

	public Class<Annotation>[] getClasses() {
		return classes;
	}

	public void setClasses(Class<Annotation>[] classes) {
		this.classes = classes;
	}

	public String getAnnotationErrorView() {
		return annotationErrorView;
	}

	public void setAnnotationErrorView(String annotationErrorView) {
		this.annotationErrorView = annotationErrorView;
	}
}
