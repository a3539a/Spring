package kr.co.ch02.ioc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ��¥ : 2021/07/12
 * �̸� : ��¿�
 * ���� : ������ Ioc �ǽ��ϱ�
 */
public class IocTest1 {
	
	public static void main(String[] args) {
		
		// Ioc ���� X
		Tv ltv = new LgTv();
		ltv.power();
		ltv.chUp();
		ltv.chDown();
		
		// Ioc ���� O
		// ������ �����̳� ��ü ����
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring-context.xml");
		
		Tv lgtv = (Tv) ctx.getBean("lgtv");
		Tv smtv = (Tv) ctx.getBean("smtv");
		
		lgtv.power();
		lgtv.chUp();
		lgtv.chDown();
		
		smtv.power();
		smtv.chUp();
		smtv.chDown();
	}
}
