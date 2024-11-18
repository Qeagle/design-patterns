package design.patterns.factory.dosa;

public class DosaDetails {

	public static void main(String[] args) {
		DosaFactory.createDosa(DosaTypes.Onion).spreadFlavours();
	}
}
