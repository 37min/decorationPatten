package coffee;

import service.Beverage;

public class Decaf extends Beverage {
	public Decaf(){
		description="Decaf";
	}
	@Override
	public int cost() {
		return 1500;
	}
}
