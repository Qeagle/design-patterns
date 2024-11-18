package solid.interfacesegregation;

public class Tester implements SoftwareQA{

	
	@Override
	public void doTesting() {
		System.out.println("I do Testing");
	
	}

	@Override
	public void attendSprintPlanning() {
		System.out.println("I attend Sprint Planning");
		
	}

	
}
