import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ActionMethod {
static Scanner scan = new Scanner(System.in);
static ArrayList<String> rentList = new ArrayList<String>();

	public static void readFromBookList() {
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
				Book b = new Book(temp[1], temp[2], temp[3], counter);
				System.out.println();
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
			int counter=1;
			while (line != null) {
				String[] temp = line.split(",");
				Book b = new Book(temp[1], temp[2], temp[3],counter);
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
				Book b = new Book(temp[1], temp[2], temp[3],counter);
				String[] tempTitle = temp[1].toLowerCase().split("[ :.,?!]+");
				
				if (Arrays.asList(tempTitle).contains(keyword.trim().toLowerCase())) {
					System.out.println(b);

					String b1 = temp[1] + ", "+ temp[2]+", " +temp[3] + ", " +counter; 
					counter++;
					searchKeyword.add(b1);
				}
				
				line = reader.readLine();
			}
			System.out.println("What book would you like to add? (Enter a number)");
			int bookChoice = scan.nextInt();
			for(int i =0; i < searchKeyword.size();i++) {
				
				if(i == bookChoice-1) {
					rentList.add(searchKeyword.get(i));
				}
			}
			System.out.println(rentList);
			reader.close();// close the file reader too
			

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}

	public static void checkOutBook() {
		
		
	}

}
