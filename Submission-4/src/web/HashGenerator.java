package web;

import java.security.MessageDigest;

import actors.Student;

public class HashGenerator {
	private static final String SALT = "salts are good, mkay?";

	public static String getHash(String user, String pass) {
		try {
			String toHash = user + SALT + pass;
			byte hashbytes[] = MessageDigest.getInstance("MD5").digest(
					toHash.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < hashbytes.length; i++) {
				sb.append(Integer.toString((hashbytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String args[]) {
		String[][] creds = new String[][] {
				{"Nihanth Subramanya", "2012A3PS151G", "abc"},
				{"Avidipto Chakraborty", "2012B3A7506G", "def"},
				{"Vipul Singh", "2012B3A7511G", "ghi"},
				{"Bhargav Srinivasa", "2013A7PS053G", "jkl"},
				{"Rohith Ramakrishnan", "2013A7PS124G", "mno"},
				{"Ayush Pandey", "2012B3A7714G", "pqr"}
		};
		for (String[] cred : creds) {
			Student.createStudent(cred[0], cred[1], cred[2], 0);
		}
	}
}
