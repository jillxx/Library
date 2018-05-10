import java.util.Scanner;

import sun.security.validator.Validator;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Library!");
		System.out.println("Please login:");
		Scanner scan = new Scanner(System.in);
		String loginId = scan.nextLine();
		
		System.out.println("Please choose from the options below:");
		System.out.println("1. Show book list");
		System.out.println("2. Show DVD list");
		System.out.println("3. Return book");
		System.out.println("4. Return DVD");
		System.out.println("3. Quit");
		
		int userChoice = scan.nextInt();
		
		if (userChoice == 1) {
			System.out.println(bookList);
	}
		if (userChoice == 2) {
			System.out.println(dvdList);
		}
		if (userChoice == 3) {
			System.out.println("What book would you like to return? (number)");
			int bookReturn = Validator.getInstance(scan,);//FileMethod.writeToFile
			int bookReturn = scan.nextInt();
			System.out.println();
		}
	}

}
