package solid.depdencyinversion;

import java.util.ArrayList;
import java.util.List;

public class BankingProject {

	public static void main(String[] args) {
		
		Developer frontEnd = new FrontEndDeveloper();
		Developer backEnd = new BackendDeveloper();
		
		List<Developer> developers = new ArrayList<Developer>();
		developers.add(backEnd);
		developers.add(frontEnd);

		Project proj = new Project(developers);
		proj.deliverProject();
	}
}
