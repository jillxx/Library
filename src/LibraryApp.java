import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Library!");
		System.out.println("Please login:");
		Scanner scan = new Scanner(System.in);
		String UserId = scan.nextLine();
		System.out.print(UserId + ", ");
		System.out.println("Please choose from the options below:");
		System.out.println("1. Search by category");
		System.out.println("2. Display our inventory");
		System.out.println("3. Return");
		System.out.println("4. Quit");

		int userChoice = scan.nextInt();

		if (userChoice == 1) {
			System.out.println("1. Search by author\n2. Search by title keyword");
			int searchChoice = scan.nextInt();
			scan.nextLine();// garbage line
			if (searchChoice == 1) {
				System.out.println("Please enter author");
				String author = scan.nextLine();
				ActionMethod.researchAuthor(author);

			}
			if (searchChoice == 2) {
				System.out.println("Please enter title keyword");
				String keyword = scan.nextLine();
				ActionMethod.researchKeyword(keyword);

			} else {
				System.out.println("The choice you entered is not avaiable");

			}

		}

		if (userChoice == 2) {

			ActionMethod.readFromBookList();
			System.out.println("\nPlease enter the book number you want to borrow");
			int borrow=scan.nextInt();
			
			//working on
			ActionMethod.checkOutBook();
			// check out and set duedate
			// already checked out. show message

		}
		if (userChoice == 3) {
			System.out.println("What book would you like to return? (enter a number)");

			// change the status of the book to null.
			// int bookReturn = Validator.getInstance(scan, )//FileMethod.writeToFile

			// int bookReturn = Validator.getInstance(scan, "Return
			// book");//FileMethod.writeToFile

			System.out.println();
		}
		scan.close();
	}

}
