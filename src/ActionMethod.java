import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ActionMethod {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> rentList = new ArrayList<String>();
	static ArrayList<String> wholeBook = new ArrayList<String>();
	
	public static void wholeArrayAdd() {
		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			int counter = 1;
			while (line != null) {
				String[] temp = line.split(",");
				wholeBook.add(line);
				line = reader.readLine();
			}

			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}
	}
		
	

	public static void readFromBookList() {
		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			System.out.printf("     %1$-50s %2$-20s %3$-10s %4$-15s %5$-15s", "BookTitle", "Author", "BookID", "Status","Due Date");
			System.out.println();
			int counter = 1;
			while (line != null) {
				String[] temp = line.split(",");
				//wholeBook.add(line); this is adding the list to an array which we can modify the txt file
				Book b = new Book(temp[1], temp[2], temp[3], counter, temp[0]);
				System.out.print(b);// this is printing the whole list
				if (temp.length>4) {
					System.out.print(temp[5]);
				}
				System.out.println();
				counter++;
				line = reader.readLine();
			}

			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}
	}

	// ==============================================================================================
	public static void checkOut(String user, int bookID) {
		Path readFile = Paths.get("library/book.txt");// get the path of the file
		File file = readFile.toFile();// convert to a file object.
		Path writeFile = Paths.get("library/temp.txt"); // create a temp file path
		File file1 = writeFile.toFile();// create a temp object.

		try {
			FileReader fr = new FileReader(file);// read char to char
			BufferedReader reader = new BufferedReader(fr);// read blocks of info
			PrintWriter outW = new PrintWriter(new FileOutputStream(file1));
			for (int i = 0; i < wholeBook.size(); i++) {
				String[] temp1 = wholeBook.get(i).split(",");

				int borrowInput = Integer.parseInt(temp1[0]);

				if (bookID == borrowInput) {
					if (!temp1[3].equals(Status.CheckedOut.toString())) {
						temp1[3] = Status.CheckedOut.toString();
						rentList.add(temp1[0] + "," + temp1[1] + "," + temp1[2] + "," + temp1[3] + "," + user + ","
								+ LocalDate.now().plusWeeks(2));
						wholeBook.set(i, temp1[0] + "," + temp1[1] + "," + temp1[2] + "," + temp1[3] + "," + user + ","
								+ LocalDate.now().plusWeeks(2));

					} else {
						System.out.println(temp1[1] + " has been checked out by another person.");
					}
				}
				outW.println(wholeBook.get(i));
			}

			outW.close();
			reader.close();

			if (!file.delete()) {// delete the old booklist file
				System.out.println("Could not delete file");
				return;
			}

			// Rename the temp file book.txt
			if (!file1.renameTo(file)) {
				System.out.println("Could not rename file");
			}
		//	System.out.println(rentList.size() + " items has been checked out.");
			// System.out.println(rentList.get(1));

		} catch (IOException e) {
			System.out.println("Something went wrong");
		}

	}

	// =================================================================================================

	public static void researchAuthor(String author, String userID) {

		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			System.out.printf("     %1$-50s %2$-20s %3$-10s %4$-10s", "BookTitle", "Author", "BookId","Status");
			System.out.println();
			int counter = 1;
			ArrayList<String> searchAuthor = new ArrayList<String>();
			while (line != null) {
				//wholeBook.add(line);
				String[] tempA = line.split(",");
				Book ba = new Book(tempA[1], tempA[2], tempA[3], counter, tempA[0]);
				String[] tempAuthor = tempA[2].toLowerCase().split("[ :.,?!]+");

				if (Arrays.asList(tempAuthor).contains(author.trim().toLowerCase())) {
					System.out.println(ba);

					String b1 = tempA[1] + "," + tempA[2] + "," + tempA[3] + "," + tempA[0];
					counter++;
					searchAuthor.add(b1);
				}

				line = reader.readLine();
			}
			reader.close();// close the file reader too

			System.out.println("\nPlease enter the bookID number you want to borrow");
			String bookANum = scan.nextLine();
			scan.close();
			for (int i = 0; i < searchAuthor.size(); i++) {
				String[] tempRent = searchAuthor.get(i).split(",");

				if (bookANum.equalsIgnoreCase(tempRent[3])) {
					int bc = Integer.parseInt(bookANum);
					checkOut(userID, bc);
					rentList.add(searchAuthor.get(i));
				}
			}

		} catch (

		IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}
	// =============================================================================================

	public static void researchKeyword(String keyword, String userID) {

		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			System.out.printf("     %1$-50s %2$-20s %3$-10s %4$-10s", "BookTitle", "Author", "BookId", "Status");
			System.out.println();
			int counter = 1;
			ArrayList<String> searchKeyword = new ArrayList<String>();
			while (line != null) {
				//wholeBook.add(line);// adding whole book list to the arraylist
				String[] temp = line.split(",");

				Book b = new Book(temp[1], temp[2], temp[3], counter, temp[0]);
				String[] tempTitle = temp[1].toLowerCase().split("[ :.,?!]+");

				if (Arrays.asList(tempTitle).contains(keyword.trim().toLowerCase())) {
					System.out.println(b);

					String b1 = temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[0];
					counter++;
					searchKeyword.add(b1);
				}

				line = reader.readLine();
			}
			reader.close();// close the file reader too

			System.out.println("\nPlease enter the bookID number you want to borrow");
			String bookChoice = scan.nextLine();

			for (int i = 0; i < searchKeyword.size(); i++) {

				String[] tempRent = searchKeyword.get(i).split(",");

				if (bookChoice.equalsIgnoreCase(tempRent[3])) {
					int bc = Integer.parseInt(bookChoice);
					checkOut(userID, bc);
					rentList.add(searchKeyword.get(i));
				}

			}

			// System.out.println(rentList);
		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}

	// ========================================================================================
	public static void pullRentList(String userID) {
		Path readFile = Paths.get("library/book.txt");// get the path of the file
		File file = readFile.toFile();// convert to a file object.

		
			//FileReader fr = new FileReader(file);// read char to char
			//BufferedReader reader = new BufferedReader(fr);// read blocks of info

			
			/*while (line != null) {
				wholeBook.add(line);
				line = reader.readLine();
			}*/
			System.out.printf("     %1$-50s %2$-20s %3$-10s %4$-10s", "BookTitle", "Author", "Status", "BookId");
			System.out.println();
			int counterR = 1;
			for (int i = 0; i < wholeBook.size(); i++) {
				String[] tempR = wholeBook.get(i).split(",");

				if (tempR[3].equals(Status.CheckedOut.toString()) && (userID.equalsIgnoreCase(tempR[4].toString()))) {// FIXME
																														// exception
																														// throwed
					Book br = new Book(tempR[1], tempR[2], tempR[3], counterR, tempR[0]);
					System.out.println(br);
					counterR++;
				}
			}}
		

	// =========================================================
	public static void returnMethod(String userID, int bookID) {
		Path readFile = Paths.get("library/book.txt");// get the path of the file
		File file = readFile.toFile();// convert to a file object.
		Path writeFile = Paths.get("library/temp.txt"); // create a temp file path
		File file1 = writeFile.toFile();// create a temp object.

		try {
			FileReader fr = new FileReader(file);// read char to char
			BufferedReader reader = new BufferedReader(fr);// read blocks of info
			PrintWriter outW = new PrintWriter(new FileOutputStream(file1));

			for (int i = 0; i < wholeBook.size(); i++) {
				String[] temp1 = wholeBook.get(i).split(",");
				int returnID = Integer.parseInt(temp1[0]);

				if ((bookID == returnID)) {
					if (!temp1[3].equals(Status.OnShelf.toString())) {

						temp1[3] = Status.OnShelf.toString();
						wholeBook.set(i, temp1[0] + "," + temp1[1] + "," + temp1[2] + "," + Status.OnShelf);

					} else {
						System.out.println(temp1[1] + " has been returned.");
					}
				}
				outW.println(wholeBook.get(i));
			}

			outW.close();
			reader.close();

			if (!file.delete()) {// delete the old booklist file
				System.out.println("Could not delete file");
				return;
			}

			// Rename the temp file book.txt
			if (!file1.renameTo(file)) {
				System.out.println("Could not rename file");
			}
			System.out.println(rentList.size() + " item(s) have been returned out.");
			// System.out.println(rentList.get(1));

		} catch (IOException e) {
			System.out.println("Something went wrong");
		}

	}



	public static void addBook(String userString) {
		Path readFile = Paths.get("library/book.txt");// get the path of the file
		File file = readFile.toFile();// convert to a file object.
		Path writeFile = Paths.get("library/temp.txt"); // create a temp file path
		File file1 = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);// read char to char
			BufferedReader reader = new BufferedReader(fr);// read blocks of info
			PrintWriter outW = new PrintWriter(new FileOutputStream(file1));
			
		String[] temp1 = wholeBook.get(wholeBook.size()-1).split(",");
		int newBookID = Integer.parseInt(temp1[0]);
		newBookID++;
		wholeBook.add(newBookID +"," + userString + "," + Status.OnShelf);
		System.out.println("You added :" + userString);
		for (int i = 0; i < wholeBook.size(); i++) {
			
			outW.println(wholeBook.get(i));
		}

		outW.close();
		reader.close();

		if (!file.delete()) {// delete the old booklist file
			System.out.println("Could not delete file");
			return;
		}

		// Rename the temp file book.txt
		if (!file1.renameTo(file)) {
			System.out.println("Could not rename file");
		}

	} catch (IOException e) {
		System.out.println("Something went wrong");
	}
	}

}
