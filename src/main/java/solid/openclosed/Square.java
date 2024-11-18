package solid.openclosed;

public class Square implements Shape{
	
	double side;
	
	public Square(double radius) {
		this.side = radius;
	}

	@Override
	public double calculateArea() {
		return side*side;
	}

}
