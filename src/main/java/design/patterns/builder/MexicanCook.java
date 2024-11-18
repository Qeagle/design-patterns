package design.patterns.builder;

public class MexicanCook implements Cook{
	
	private Pizza pizza;
	
	public MexicanCook() {
		this.pizza = new Pizza();
	}

	@Override
	public Pizza buildDough() {
		pizza.setDough("Mexican Dough");
		return this.pizza;
	}

	@Override
	public Pizza setupBase() {
		pizza.setBase("Mexican Size");
		return this.pizza;
	}

	@Override
	public Pizza spreadSauce() {
		pizza.setBase("Mexican Sauce");
		return this.pizza;
	}

	@Override
	public Pizza applyToppings() {
		pizza.setBase("Mexican Toppings");
		return this.pizza;
	}

	@Override
	public Pizza doBaking() {
		pizza.setBase("Mexican Bake with special timings");
		return this.pizza;
	}

}
