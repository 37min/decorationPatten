package decoration;

import service.Beverage;
import service.CondimentDecorator;

public class Whip extends CondimentDecorator{
	Beverage beverage;

	public Whip(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	public String getDescription() {
		return beverage.getDescription()+"+Whip";
	}
	@Override
	public int cost() {
		return beverage.cost()+1500;
	}
}
