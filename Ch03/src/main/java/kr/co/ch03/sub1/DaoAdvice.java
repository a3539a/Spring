package kr.co.ch03.sub1;

import org.springframework.stereotype.Component;

@Component
public class DaoAdvice {
	
	public void beforeAdvice1() {
		System.out.println("===============================");
		System.out.println("�ΰ���� - beforeAdvie1");
	}
	public void beforeAdvice2() {
		System.out.println("===============================");
		System.out.println("�ΰ���� - beforeAdvie2");
		}
	public void beforeAdvice3() {
		System.out.println("===============================");
		System.out.println("�ΰ���� - beforeAdvie3");
		}
	public void afterAdvice1() {
		System.out.println("�ΰ���� - afterAdvie1");
		System.out.println("-------------------------------");
		}
	public void afterAdvice2() {
		System.out.println("�ΰ���� - afterAdvie2");
		System.out.println("-------------------------------");
		}
	public void afterAdvice3() {
		System.out.println("�ΰ���� - afterAdvie3");
		System.out.println("-------------------------------");
		}

}
