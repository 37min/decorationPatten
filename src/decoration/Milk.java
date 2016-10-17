package decoration;

import service.Beverage;
import service.CondimentDecorator;

public class Milk extends CondimentDecorator{
	Beverage beverage;
	
	public Milk(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	
	public String getDescription() {
		if (beverage.getDescription().equals("Espresso"))
		{
			return this.description = "CAFELATTE";
		}
		
		return beverage.getDescription()+"+Milk";
	}
	@Override
	public int cost() {
		return beverage.cost()+500;
	}
}
