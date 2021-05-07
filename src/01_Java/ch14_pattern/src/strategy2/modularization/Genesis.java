package strategy2.modularization;

import strategy2.component.EngineHigh;
import strategy2.component.FuelGasoline;
import strategy2.component.Km10;

//최고급엔진(EngineHigh).  연비 10Km/l(Km10). 휘발유(FuelGasoline)

public class Genesis extends Car{
	
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	public void shape() { // 오버라이드
		System.out.println("Genesis");
		super.shape();
	}

}
