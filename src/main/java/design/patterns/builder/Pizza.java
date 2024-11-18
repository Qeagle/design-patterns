package design.patterns.builder;

public class Pizza {
	
	private String dough;
	private String base;
	private String sauce;
	private String toppings;
	private String extratoppings;
	
	public String getDough() {
		return dough;
	}
	
	public void setDough(String dough) {
		this.dough = dough;
	}
	
	public String getBase() {
		return base;
	}
	
	public void setBase(String base) {
		this.base = base;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public String getExtratoppings() {
		return extratoppings;
	}

	public void setExtratoppings(String extratoppings) {
		this.extratoppings = extratoppings;
	}
	
	
	public void getPizza() {
		System.out.println("Dough: "+dough+", Base: "+base+" Sauce: "+sauce+" Toppings: "+toppings+"");
	}
	

	
	

}
