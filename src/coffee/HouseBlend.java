package coffee;

import service.Beverage;

public class HouseBlend extends Beverage{
	public HouseBlend(){
		description="HouseBlend";
	}
	@Override
	public int cost() {
		return 2000;
	}
}
