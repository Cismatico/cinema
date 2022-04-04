package mainPackage;

public class Start {

	public static void main(String[] args) {

		DbController dbController = new DbController();
		Controller controller = new Controller(dbController);
		View view = new View(controller);

		view.readAllData();
		view.mainMenu();
	}
}
