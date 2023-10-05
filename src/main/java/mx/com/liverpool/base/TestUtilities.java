package mx.com.liverpool.base;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtilities extends BaseTest {
	private String loginData = readFile();

	public String getUsername() {
		String strPattern = "(?<=username=\\\")(.*?)(?=\\\")";

		return findMatch(strPattern, loginData);
	}

	public String getPassword() {
		String strPattern = "(?<=password=\\\")(.*?)(?=\\\")";

		return findMatch(strPattern, loginData);
	}

	public String findMatch(String strPattern, String data) {
		String result = "";
		Pattern pattern = Pattern.compile(strPattern);
		Matcher matcher = pattern.matcher(data);

		while (matcher.find()) {
			result = matcher.group();
		}

		return result;
	}

	public String readFile() {
		String data = "";
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Utilities"
				+ File.separator + "test_data.txt";
		try {
			File file = new File(pathname);
			Scanner sc = new Scanner(file);
			data = sc.useDelimiter("\\A").next();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("\n File content:  " + data + "\n");
		return data;
	}

}
