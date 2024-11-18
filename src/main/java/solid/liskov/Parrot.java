package solid.liskov;

public class Parrot extends FlyingBird{

	@Override
	public void fly() {
		System.out.println("Parrot can fly for 2kms");
		
	}

	@Override
	public void eat() {
		System.out.println("Parrot can eat fruits");
		
	}

}
