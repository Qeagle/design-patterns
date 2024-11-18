package design.patterns.builder;

public class HeadChef {
	
	private Cook cook;
	
	public HeadChef(Cook cook) {
		this.cook = cook;
	}
	
	
	public Pizza deliverPizza() {
		cook.buildDough();
		cook.setupBase();
		cook.spreadSauce();
		cook.applyToppings();
		Pizza pizza = cook.doBaking();
		return pizza;
		
	}

}
