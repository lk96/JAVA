package com.inspur.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/*
 * ����ִ��Action���ѵ�ʱ��
 */
public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1ִ��Action֮ǰ
		long start=System.currentTimeMillis();
		//2.ִ����һ��������������Ѿ������һ������������ִ��Ŀ��Action
		String result=invocation.invoke();
		//3.ִ��Action֮��
		long end=System.currentTimeMillis();
		System.out.println("ִ��Action���ѵ�ʱ��"+(end-start)+"ms");
		
		return result;
	}

}
