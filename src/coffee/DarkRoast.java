package coffee;

import service.Beverage;

public class DarkRoast extends Beverage{
	public DarkRoast(){
		description="DarkRoast";
	}
	@Override
	public int cost() {
		return 2500;
	}
}
