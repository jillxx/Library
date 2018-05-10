import java.util.Scanner;

import sun.security.validator.Validator;

public class LibraryApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Library!");
		System.out.println("Please login:");
		Scanner scan = new Scanner(System.in);
		String loginId = scan.nextLine();
		
		System.out.println("Please choose from the options below:");
		System.out.println("1. Search by category");
		System.out.println("2. Display our inventory");
		System.out.println("3. Return");
		System.out.println("4. Quit");
		
		int userChoice = scan.nextInt();
		
		if (userChoice == 1) {
		//	System.out.println(bookList);
	}
		if (userChoice == 2) {

			ActionMethod.readFromBookList();
			System.out.println("Please enter the book number you want to borrow");
			//check out and set duedate
			//already checked out. show message

		}
		if (userChoice == 3) {
			System.out.println("What book would you like to return? (number)");

			//change the status of the book to null.
		  //  int bookReturn = Validator.getInstance(scan, )//FileMethod.writeToFile
	

		//	int bookReturn = Validator.getInstance(scan, "Return book");//FileMethod.writeToFile

			System.out.println();
		}
	}

}
