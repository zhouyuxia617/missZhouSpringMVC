package cn.et.springmvc.lesson05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInteractor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		//第一次提交
		String myToken = request.getParameter("myToken");
		//第二次提交
		Object myToken1 = request.getSession().getAttribute("myToken");
		
		//需要验证重复提交
		if(myToken != null) {
			
			//第二次为空重复提交
			if(myToken1 == null) {
				return false;
			
			}else {
				
				//判断第一次和第二次是否一样
				if(myToken.equals(myToken1)) {
					//成功之后清除
					request.getSession().removeAttribute("myToken");
					
					return true;
					
				}else {
					return false;
				}
				
			}
			
		}else {
			return true;
		}
	}
	
}
