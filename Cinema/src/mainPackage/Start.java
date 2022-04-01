package mainPackage;

public class Start {

	public static void main(String[] args) {
		Controller controller = new Controller();
		View view = new View(controller);
		
		view.mainMenu();
	}

}
