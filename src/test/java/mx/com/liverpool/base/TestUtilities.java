package mx.com.liverpool.base;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtilities extends BaseTest {
	private String loginData = readFile();

	/** Returns username string from test_data.txt file. */
	public String getUsername() {
		String strPattern = "(?<=username=\\\")(.*?)(?=\\\")";

		return findMatch(strPattern, loginData);
	}

	/** Returns password string from test_data.txt file. */
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

	/** Extract String from test_data.txt file. */
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
		return data;
	}

	/**
	 * Opens Chrome with debug arguments for selenium.
	 */
	public void openChromeWithArguments() {
		String command = "start chrome --remote-debugging-port=9222 --user-data-dir=\"C:\\selenum\\ChromeProfile\"";
		System.out.println("\n" + command + "\n");
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
		builder.redirectErrorStream(true);
		try {
			Process p = builder.start();
			System.out.println("\n" + p.toString() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
