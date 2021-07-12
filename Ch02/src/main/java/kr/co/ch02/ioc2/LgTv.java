package kr.co.ch02.ioc2;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class LgTv implements Tv {
	
	@Inject
	private Speaker spk;

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

	@Override
	public void soundUp() {
		spk.soundUp();
	}

	@Override
	public void soundDown() {
		spk.soundDown();
	}

}
