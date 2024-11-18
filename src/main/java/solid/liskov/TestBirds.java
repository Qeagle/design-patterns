package solid.liskov;

public class TestBirds {
	
	public static void main(String[] args) {
		
		Parrot parrot = new Parrot();
		Bird penguin = new Penguin();
		
		parrot.eat();
		parrot.fly();
		
		penguin.eat();
		
		
	}

}

// Spearations of behaviours !!
// Prevented Runtime errors !!

// Button --> type?? click

// WebElement --> WebInput, WebButton, WebSelect