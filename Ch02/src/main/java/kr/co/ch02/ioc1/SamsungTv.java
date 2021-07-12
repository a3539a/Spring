package kr.co.ch02.ioc1;

public class SamsungTv  implements Tv{

	@Override
	public void power() {
		System.out.println("SamsungTv - Power...");
	}

	@Override
	public void chUp() {
		System.out.println("SamsungTv - ChUp...");
	}

	@Override
	public void chDown() {
		System.out.println("SamsungTv - ChDown...");
	}

}
