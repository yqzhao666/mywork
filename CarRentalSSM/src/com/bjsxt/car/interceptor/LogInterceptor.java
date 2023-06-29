package com.bjsxt.car.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.car.pojo.Users;
import com.bjsxt.car.service.InterceptorService;
import com.bjsxt.car.service.impl.InterceptorServiceImpl;

/**
 * creat by gaoyu 2017��11��15��
 */
public class LogInterceptor implements HandlerInterceptor {

	@Autowired
	private InterceptorService myInterServiceImpl;

	/*
	 * �ڵ�controller֮ǰִ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1,
			Object arg2) throws Exception {
		return true;
	}

	/*
	 * jspǰ
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2, ModelAndView arg3) throws Exception {
		
		String flagName = "";
		if (arg2 instanceof HandlerMethod) {
			// ��ȡ������
			HandlerMethod hd = (HandlerMethod) arg2;
			flagName = hd.getMethod().getName();
			System.out.println("������flag====" + hd.getMethod().getName());
		}
		// ��ȡ�û�
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		if (null == user || "".equals(user)) {
			return;
		}
		String userName = user.getFullname();
		System.out.println("������username====" + user.getFullname());

		// ��ȡaction
		String action = req.getRequestURI().toString();
		//String action = req.getServletPath().toString();
		System.out.println("������action=====" + action);
		
		//��ȡ�ͻ���ip
		String clientIp = req.getRemoteAddr();
		//���ݴ���
		myInterServiceImpl.saveInter(flagName, userName, action ,clientIp);
	}

	/*
	 * jsp֮��
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
