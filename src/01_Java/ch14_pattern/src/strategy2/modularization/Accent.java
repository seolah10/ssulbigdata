package strategy2.modularization;

import strategy2.component.EngineLow;
import strategy2.component.FuelDiesel;
import strategy2.component.Km20;

public class Accent extends Car {

	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}		

	public void shape() {
		System.out.println("Accent");
		super.shape();
	}
}
