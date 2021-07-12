package kr.co.ch02.ioc2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTv  implements Tv{
	
	@Autowired
	private Speaker spk;

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

	@Override
	public void soundUp() {
		spk.soundUp();
	}

	@Override
	public void soundDown() {
		spk.soundDown();
	}

}
