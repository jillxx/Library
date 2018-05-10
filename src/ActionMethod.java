import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ActionMethod {

	public static void readFromBookList() {
		Path readFile = Paths.get("library/book.txt");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();
System.out.printf("%1$-30s %2$-10s","bookTitle","Author");
			while (line != null) {
				String[] temp = line.split(",");
		Book b = new Book(temp[0], temp[1]);
			 System.out.println();
				// System.out.println(temp[0]);
				System.out.println(b);
				line = reader.readLine();
			}

			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("The system is crashed, please try again");
		}

	}

	
}
