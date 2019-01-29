package com.wanxp.blog.interceptor;

import com.wanxp.blog.util.F;
import com.wanxp.blog.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 权限拦截器
 * 
 * @author John
 * 
 */
public class TokenInterceptor implements HandlerInterceptor {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

	private List<String> excludeUrls;// 不需要拦截的资源

	private List<String> tokenUrls;  //tocken认证资源
	
	private TokenManage tokenManage;
	
	public List<String> getTokenUrls() {
		return tokenUrls;
	}

	public void setTokenUrls(List<String> tokenUrls) {
		this.tokenUrls = tokenUrls;
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}

		String tokenId = request.getParameter(TokenManage.TOKEN_FIELD);
		if(F.empty(tokenId) || !tokenManage.validToken(tokenId)) {
			request.getRequestDispatcher("/api/apiCommon/error").forward(request, response);
			return false;
		}

		if (url.indexOf("/api/apiCommon/validToken") > -1) {
			return true;
		}

		String param = "";
		Map<String, String[]> paramMap = request.getParameterMap();
		if(!paramMap.isEmpty()) {
			for(String key : paramMap.keySet()) {
				if(!F.empty(param)) param += "&";
				param += key + "=" + paramMap.get(key)[0];
			}
		}

//		Enumeration headerNames = request.getHeaderNames();
//		while (headerNames.hasMoreElements()) {
//			String key = (String) headerNames.nextElement();
//			String value = request.getHeader(key);
//			System.out.println("key:" + key + "   " + "value:" + value);
//		}

		//签名验证
		String sign = request.getHeader("sign");
//		System.out.println("requestUri:" + requestUri);
//		System.out.println("param:" + param);
//		System.out.println("sign:" + sign);
//		System.out.println("MD5Util.md5:" + MD5Util.md5(URLEncoder.encode(param + tokenId, "UTF-8").replaceAll("[+]", "%20")));
		if (F.empty(sign) || !sign.equals(MD5Util.md5(URLEncoder.encode(param + tokenId, "UTF-8").replaceAll("[+]", "%20")))) {
			request.getRequestDispatcher("/api/apiCommon/error").forward(request, response);
			return false;
		}

		return true;
	}

	public void setTokenManage(TokenManage tokenManage) {
		this.tokenManage = tokenManage;
	}
	
}
