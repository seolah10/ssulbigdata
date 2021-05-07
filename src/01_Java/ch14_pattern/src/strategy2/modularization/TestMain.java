package strategy2.modularization;

import strategy2.component.FuelHybrid;
import strategy2.component.Km20;

public class TestMain {

			public static void main(String[] args) {
				
				Genesis genesis = new Genesis();
				Sonata sonata = new Sonata();
				Accent accent = new Accent();
				
				Car[] cars = {genesis, sonata, accent};
				
				for(Car car : cars) {
					car.shape();
					car.drive();
					car.isEngine();
					car.isKm();
					car.isFuel();
				} // for
				System.out.println("소나타의 연료를 Hybrid로, 연비를 20km/l로 업그레이드");
				
				sonata.setFuel(new FuelHybrid());
				sonata.setKm(new Km20());
				
				for(Car car : cars) {
					car.shape();
					car.drive();
					car.isEngine();
					car.isKm();
					car.isFuel();
				}
 			}
}
