package web;

import java.security.MessageDigest;

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
				{"nihanth", "abc"},
				{"avidipto", "def"},
				{"vipul", "ghi"},
				{"bhargav", "jkl"},
				{"rohit", "mno"},
				{"ayush", "pqr"}
		};
		for (String[] cred : creds) {
			System.out.println(cred[0] + " " + cred[1] + ": " + getHash(cred[0], cred[1]));
		}
	}
}
