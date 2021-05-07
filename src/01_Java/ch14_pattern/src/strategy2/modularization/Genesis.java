package strategy2.modularization;

import strategy2.component.EngineHigh;
import strategy2.component.FuelGasoline;
import strategy2.component.Km10;

//�ְ�޿���(EngineHigh).  ���� 10Km/l(Km10). �ֹ���(FuelGasoline)

public class Genesis extends Car{
	
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	public void shape() { // �������̵�
		System.out.println("Genesis");
		super.shape();
	}

}
