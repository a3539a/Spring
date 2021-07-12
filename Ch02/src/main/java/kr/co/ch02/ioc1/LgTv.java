package kr.co.ch02.ioc1;

public class LgTv implements Tv {

	@Override
	public void power() {
		System.out.println("LgTv - Power...");
	}

	@Override
	public void chUp() {
		System.out.println("LgTv - ChUp...");
	}

	@Override
	public void chDown() {
		System.out.println("LgTv - ChDown...");
	}

}
