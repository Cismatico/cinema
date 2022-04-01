package mainPackage;

import java.util.Scanner;

public class View {
	private Scanner scan;
	private Controller controller;

	public View(Controller controller) {
		this.scan = new Scanner(System.in);
		this.controller = controller;
	}

	public void mainMenu() {
		while (true) {
			System.out.println("Main menu\n");
			System.out.println("1. List menu");
			System.out.println("2. Modify menu");
			System.out.println("0. Exit");
			String key = scan.nextLine();
			switch (key) {
			case "1":
				listMenu();
				break;
			case "2":
				modifyMenu();
				break;
			case "0":
				System.exit(0);
			default:
				System.out.println("Wrong input, try again");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void listMenu() {
		while (true) {
			System.out.println("List menu\n");
			System.out.println("1. Print films");
			System.out.println("2. Print series");
			System.out.println("0. Main menu");
			String key = scan.nextLine();
			switch (key) {
			case "1":
				printFilm();
				break;
			case "2":

				break;
			case "0":
				mainMenu();
				break;
			default:
				System.out.println("Wrong input, try again");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void modifyMenu() {
		while (true) {
			System.out.println("Modify menu\n");
			System.out.println("1. Add menu");
			System.out.println("2. Modify menu");
			System.out.println("3. Remove menu");
			System.out.println("0. Main menu");
			String key = scan.nextLine();
			switch (key) {
			case "1":
				addFilmInput();
				break;
			case "2":
				
				break;
			case "0":
				mainMenu();
				break;
			default:
				System.out.println("Wrong input, try again");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void addMenu() {
		while (true) {
			System.out.println("Add menu\n");
			System.out.println("1. Add film");
			System.out.println("2. Add serie");
			System.out.println("0. Main menu");
			String key = scan.nextLine();
			switch (key) {
			case "1":
				addFilmInput();
				break;
			case "2":

				break;
			case "0":
				mainMenu();
				break;
			default:
				System.out.println("Wrong input, try again");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void addFilmInput() {
		boolean exit = false;
		while (!exit) {
			System.out.println("Title:");
			String title = scan.nextLine();
			System.out.println("Year:");
			int year = Integer.parseInt(scan.nextLine());
			System.out.println("Country:");
			String country = scan.nextLine();
			System.out.println("Director:");
			String director = scan.nextLine();
			System.out.println("Music director:");
			String musicDirector = scan.nextLine();
			System.out.println("Duration:");
			int duration = Integer.parseInt(scan.nextLine());;
			System.out.println("Is the data correct?");
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Country: " + country);
			System.out.println("Director: " + director);
			System.out.println("Music director: " + musicDirector);
			System.out.println("Duration: " + duration);
			System.out.println("1. Yes");
			System.out.println("2. No (repeat input)");
			System.out.println("0. Return");
			String key = scan.nextLine();
			switch (key) {
			case "1":
				controller.addFilm(title, year, country, director, musicDirector, duration);
				exit = true;
				break;
			case "2":
				break;
			case "0":
				return;
			default:
				System.out.println("Wrong input, try again");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	public void printFilm() {
		System.out.println("Title  Year  Country  Director  Music  Duration");
		for (Film f : controller.getFilmList()) {
			System.out.print(f.getTitle() + "  ");
			System.out.print(f.getYear() + "  ");
			System.out.print(f.getCountry() + "  ");
			System.out.print(f.getDirector() + "  ");
			System.out.print(f.getMusicDirector() + "  ");
			System.out.print(f.getDuration() + "  ");
			System.out.println();
		}
	}
}
