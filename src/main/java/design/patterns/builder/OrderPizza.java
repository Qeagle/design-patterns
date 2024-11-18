package design.patterns.builder;

public class OrderPizza {
	
	public static void main(String[] args) {
		
		//ItalianPizza
		
		Cook cook  = new MexicanCook();
		HeadChef chef = new HeadChef(cook);
		chef.deliverPizza().getPizza();
		

	}

}

// Order of Sequence >> Maintain >> Allowed to skip few methods 
// 
