package design.patterns.builder;

public interface Cook {
	
	public Pizza buildDough();
	public Pizza setupBase();
	public Pizza spreadSauce();
	public Pizza applyToppings();
	public Pizza doBaking();
	

}
