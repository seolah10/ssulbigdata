package strategy2.modularization;

//모든 자동차는 기본적으로 drive할 수 있어야 합니다.
//자동차 모양은 door, sheet, handle로 이루어져 있습니다.

import strategy2.component.EngineImpl;
import strategy2.component.FuelImpl;
import strategy2.component.KmImpl;

public class Car {

		private EngineImpl engine;
		private KmImpl km;
		private FuelImpl fuel;
		
		public void shape() {
			System.out.println("door, sheet. handle이 있습니다.");
		}
		public void drive() {
			System.out.println("drive를 할 수 있습니다. 뭐 차니까 당연히..");
		}
		public void isEngine() {
			engine.engine();
		}
		public void isKm() {
			km.km();
		}
		public void isFuel() {
			fuel.fuel();
		}
		public void setEngine(EngineImpl engine) {
			this.engine = engine;
		}
		public void setKm(KmImpl km) {
			this.km = km;
		}
		public void setFuel(FuelImpl fuel) {
			this.fuel = fuel;
		}
		
}
