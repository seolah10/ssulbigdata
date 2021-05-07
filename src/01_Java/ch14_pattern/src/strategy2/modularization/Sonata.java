package strategy2.modularization;

import strategy2.component.EngingMid;
import strategy2.component.FuelGasoline;
import strategy2.component.Km15;

public class Sonata extends Car {
	
		public Sonata() {
				setEngine(new EngingMid());
				setKm(new Km15());
				setFuel(new FuelGasoline());
		}
		public void shape() {
			System.out.println("Sonata");
			super.shape();
		}

}
