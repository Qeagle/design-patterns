package solid.openclosed;


public class TestShape {

	public static void main(String[] args) {
		
		AreaCalculator area = new AreaCalculator();
		System.out.println(area.calculateArea(new Circle(4)));
		System.out.println(area.calculateArea(new Rectangle(4,5)));
	}
}
