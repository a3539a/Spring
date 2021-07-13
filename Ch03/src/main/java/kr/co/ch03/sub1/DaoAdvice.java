package kr.co.ch03.sub1;

import org.springframework.stereotype.Component;

@Component
public class DaoAdvice {
	
	public void beforeAdvice1() {
		System.out.println("===============================");
		System.out.println("부가기능 - beforeAdvie1");
	}
	public void beforeAdvice2() {
		System.out.println("===============================");
		System.out.println("부가기능 - beforeAdvie2");
		}
	public void beforeAdvice3() {
		System.out.println("===============================");
		System.out.println("부가기능 - beforeAdvie3");
		}
	public void afterAdvice1() {
		System.out.println("부가기능 - afterAdvie1");
		System.out.println("-------------------------------");
		}
	public void afterAdvice2() {
		System.out.println("부가기능 - afterAdvie2");
		System.out.println("-------------------------------");
		}
	public void afterAdvice3() {
		System.out.println("부가기능 - afterAdvie3");
		System.out.println("-------------------------------");
		}

}
