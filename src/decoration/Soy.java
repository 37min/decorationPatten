package decoration;

import service.Beverage;
import service.CondimentDecorator;

public class Soy extends CondimentDecorator{
	Beverage beverage;

	public Soy(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	public String getDescription() {
		return beverage.getDescription()+"+Soy";
	}
	@Override
	public int cost() {
		return beverage.cost()+1000;
	}
}
