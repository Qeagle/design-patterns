package design.patterns.builder;

public class ItalianCook implements Cook{
	
	private Pizza pizza;
	
	public ItalianCook() {
		this.pizza = new Pizza();
	}

	@Override
	public Pizza buildDough() {
		pizza.setDough("Italian Dough");
		return this.pizza;
	}

	@Override
	public Pizza setupBase() {
		pizza.setBase("Italian Size");
		return this.pizza;
	}

	@Override
	public Pizza spreadSauce() {
		pizza.setBase("Italian Sauce");
		return this.pizza;
	}

	@Override
	public Pizza applyToppings() {
		pizza.setBase("Italian Toppings");
		return this.pizza;
	}

	@Override
	public Pizza doBaking() {
		pizza.setBase("Italian Bake with special timings");
		return this.pizza;
	}

}
