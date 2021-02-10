//JavaSE-1.7
/*
package seleniumautomation.com.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EmailsGenerator {

	private static final String FILE_PATH = "Email.txt";
	private static final String MAIL_PATTERN = "rafael@testes.com:";

	public static String getNextEmail() {
		int index = 0;
		String mail = null;

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line = br.readLine();

			String[] mailArr = line.split(":");
			mail = mailArr[0];
			index = Integer.parseInt(mailArr[1]);

			int atIndex = mail.indexOf("@");
			mail = mail.substring(0, atIndex) + ++index + mail.substring(atIndex);
		} catch (IOException e) {

		}

		try (PrintWriter writer = new PrintWriter(FILE_PATH, "UTF-8")) {
		    writer.println(MAIL_PATTERN + index);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {

		}

		return mail;
	}

	public static String getCurrentEmail() {

		int index = 0;
		String email = null;

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			String line = br.readLine();
			String[] mailArr = line.split(":");
			email = mailArr[0];
			index = Integer.parseInt(mailArr[1]);
			int atIndex = email.indexOf("@");
			email = email.substring(0, atIndex) + index + email.substring(atIndex);

		} catch (IOException e) {

		}

		return email;
	}
}
 */

//JavaSE-1.7
package seleniumautomation.com.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.Math;

public class EmailsGenerator {

	private static final String FILE_PATH = "Email.txt";

	public static String getNextEmail() {
		int index = (int)Math.round((Math.random() * 10000));
		String mailInput = null;
		String mailOutput = null;

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line = br.readLine();

			String[] mailArr = line.split(":");
			mailInput = mailArr[0];

			int atIndex = mailInput.indexOf("@");
			mailOutput = mailInput.substring(0, atIndex) + index + mailInput.substring(atIndex);
		} catch (IOException e) {

		}

		try (PrintWriter writer = new PrintWriter(FILE_PATH, "UTF-8")) {
			writer.println(mailInput + ":" + index);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {

		}

		return mailOutput;
	}

	public static String getCurrentEmail() {

		int index = 0;
		String email = null;

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			String line = br.readLine();
			String[] mailArr = line.split(":");
			email = mailArr[0];
			index = Integer.parseInt(mailArr[1]);
			int atIndex = email.indexOf("@");
			email = email.substring(0, atIndex) + index + email.substring(atIndex);

		} catch (IOException e) {

		}

		return email;
	}
}
