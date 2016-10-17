package coffee;

import service.Beverage;

public class Espresso extends Beverage{
	public Espresso(){
		description="Espresso";
	}
	@Override
	public int cost() {
		return 3000;
	}
}
