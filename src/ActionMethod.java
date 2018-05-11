import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ActionMethod {
	static Scanner scan = new Scanner(System.in);

	static ArrayList<String> rentList = new ArrayList<String>();
	static ArrayList<String> wholeBook = new ArrayList<String>();

	public static void checkOut(int borrow, String user) {
		for (int i = 0; i < wholeBook.size(); i++) {
			String[] temp1 = wholeBook.get(i).split(",");

			int borrowInput = Integer.parseInt(temp1[0]);

			if (borrow == borrowInput) {
				temp1[3] = Status.CheckedOut.toString();

				rentList.add(temp1[0] + "," + temp1[1] + "," + temp1[2] + "," + temp1[3] + "," + user + "," + 2222);
				System.out.println(rentList);
				wholeBook.set(i, temp1[0] + "," + temp1[1] + "," + temp1[2] + "," + temp1[3] + "," + user + "," + 2222);
				
			}
			Path readFile = Paths.get("book.txt");// get the path of the file
			File file = readFile.toFile();// convert to a file object.
			Path writeFile = Paths.get("temp.txt"); // create a temp file path
			File file1 = writeFile.toFile();// create a temp object.

			try {
				FileReader fr = new FileReader(file);// read char to char

				BufferedReader reader = new BufferedReader(fr);// read blocks of info
				PrintWriter outW = new PrintWriter(new FileOutputStream(file1));

				String line = null;

				while ((line = reader.readLine()) != null) {
					// write the line to new file when the line is not the input text.

					outW.println(line);
				}

				outW.close();
				reader.close();// close the file reader
				// Delete the original file
				if (!file.delete()) {
					System.out.println("Could not delete file");
					return;
				}

				// Rename the new file to the filename the original file had.
				if (!file1.renameTo(file))
					System.out.println("Could not rename file");
			} catch (IOException e) {
				System.out.println("Something went wrong");
			}

		}
	}

	public static void readFromBookList() {
		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			System.out.printf("     %1$-50s %2$-20s %3$-10s %4$-10s", "BookTitle", "Author", "Status", "BookId");
			System.out.println();
			int counter = 1;
			while (line != null) {
				String[] temp = line.split(",");
				wholeBook.add(line);// this is adding the list to an array which we can modify the txt file
				Book b = new Book(temp[1], temp[2], temp[3], counter, temp[0]);
				System.out.println(b);// this is printing the whole list
				// System.out.println(temp[0]);
				counter++;
				line = reader.readLine();
			}

			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}

	public static void researchAuthor(String author) {

		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			System.out.printf("     %1$-50s %2$-20s %3$-10s", "BookTitle", "Author", "Status");
			System.out.println();
			int counter = 1;
			while (line != null) {
				String[] temp = line.split(",");
				Book b = new Book(temp[1], temp[2], temp[3], counter, temp[0]);
				if (temp[2].equalsIgnoreCase(author)) {
					System.out.println();

					System.out.println(b);
					counter++;
				}
				line = reader.readLine();
			}

			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}

	public static void researchKeyword(String keyword) {

		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
			System.out.printf("     %1$-50s %2$-20s %3$-10s", "BookTitle", "Author", "Status");
			System.out.println();
			int counter = 1;
			ArrayList<String> searchKeyword = new ArrayList<String>();
			while (line != null) {
				String[] temp = line.split(",");
				Book b = new Book(temp[1], temp[2], temp[3], counter, temp[0]);
				String[] tempTitle = temp[1].toLowerCase().split("[ :.,?!]+");

				if (Arrays.asList(tempTitle).contains(keyword.trim().toLowerCase())) {
					System.out.println(b);

					String b1 = temp[1] + ", " + temp[2] + ", " + temp[3] + ", " + counter + ", " + temp[0];
					counter++;
					searchKeyword.add(b1);
				}

				line = reader.readLine();
			}
			System.out.println("What book would you like to add? (Enter a number)");
			int bookChoice = scan.nextInt();
			for (int i = 0; i < searchKeyword.size(); i++) {

				if (i == bookChoice - 1) {
					rentList.add(searchKeyword.get(i));
				}
			}
			System.out.println(rentList);
			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}

}
