package decoration;

import service.Beverage;
import service.CondimentDecorator;

public class Mocha extends CondimentDecorator{
	Beverage beverage;

	public Mocha(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	public String getDescription() {
		if (beverage.getDescription().equals("HouseBlend"))
		{
			return this.description = "CAFEMOCHA";
		}
		
		return beverage.getDescription()+"+Mocha";
	}
	@Override
	public int cost() {
		return beverage.cost()+700;
	}
}
