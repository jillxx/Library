import java.util.Scanner;
public class LibraryApp {


	
    public static void main(String[] args) {
        System.out.println("Welcome to the Library!");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String userID = Validator.getString(scan, "Please enter your name:");
        System.out.print(userID + ", ");
        System.out.println("Please choose from the options below:");
        System.out.println("1. Search by category");
        System.out.println("2. Display our inventory");
        System.out.println("3. Return");
        System.out.println("4. Quit");
        int userChoice = scan.nextInt();
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (userChoice == 1) {
            int searchChoice = Validator.getInt(scan, "1. Search by author\n2. Search by title keyword", 1, 2);
            if (searchChoice == 1) {
                String author = Validator.getString(scan, "Please enter author");
                ActionMethod.researchAuthor(author);
            }
            if (searchChoice == 2) {
                String keyword = Validator.getString(scan, "Please enter title keyword");
                ActionMethod.researchKeyword(keyword,userID);
                // ActionMethod.checkOut(userID, borrow);// FIXME
            } else {
                System.out.println("The choice you entered is not avaiable");
            }
        }
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (userChoice == 2) {
            System.out.println("The books in our library are listed below: ");// done
            ActionMethod.readFromBookList();
            String count = "y";
            // check out and set duedate
            // already checked out. show message
            while (count.equalsIgnoreCase("y")) {
                int bookID = Validator.getInt(scan, "\nPlease enter the bookID number you want to borrow", 001, 012);
                ActionMethod.checkOut(userID, bookID);
                count = Validator.getString(scan, "Would you like to borrow another book? (y/n)");
            }
        }
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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