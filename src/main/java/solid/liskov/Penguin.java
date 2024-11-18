package solid.liskov;

public class Penguin extends NonFlyingBird{

	@Override
	public void eat() {
		System.out.println("Penguin can eat");
		
	}

}
