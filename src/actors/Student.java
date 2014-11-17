package actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web.HashGenerator;
import backend.DatabaseManager;

public class Student extends Person {
	private String studentName;
	private String studentId;
	private int messOption;
	private int dbId;

	public Student(int dbId) throws SQLException {
		this.dbId = dbId;
		Connection c = DatabaseManager.getConnection();
		PreparedStatement s = c
				.prepareStatement("SELECT * FROM StudentList WHERE SR=?;");
		s.setInt(1, dbId);
		s.execute();
		ResultSet rs = s.getResultSet();
		rs.first();
		this.studentName = rs.getString("Name");
		this.studentId = rs.getString("Id");
		this.messOption = rs.getInt("Mess");
		s.close();
		c.close();
	}

	private Student(String name, String id, int mess, int dbId) {
		this.studentName = name;
		this.studentId = id;
		this.messOption = mess;
		this.dbId = dbId;
	}

	public int getDesignation() {
		return Person.STUDENT;
	}

	public int getId() {
		return dbId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void voteForMess() {
		/*
		 * Add Code To Implement This
		 */
	}

	public void applyForLeave() {
		/*
		 * Add Code To Implement This
		 */
	}

	public String getName() {
		return studentName;
	}

	public static void main(String args[]) throws Exception {
		createStudent("John Doe", "2012A1PS654G", "passwordssuck!", 0);
	}

	public static Student createStudent(String name, String id, String pass,
			int mess) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement(
							"INSERT INTO StudentList (Name, Id, Mess) VALUES(?, ?, ?);",
							Statement.RETURN_GENERATED_KEYS);
			s.setString(1, name);
			s.setString(2, id);
			s.setInt(3, mess);
			s.execute();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			int dbId = rs.getInt(1);
			s = c.prepareStatement("INSERT INTO Login (Hash, User_Id, User_Designation) VALUES(?, ?, ?);");
			s.setString(1, HashGenerator.getHash(id.toLowerCase(), pass));
			s.setInt(2, dbId);
			s.setInt(3, 0);
			s.execute();
			return new Student(name, id, mess, dbId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void fillComplaint(String complaintSubject, String complaintBody) {
		/*
		 * Add Code To Implement This
		 */
		// Complaint c = new Complaint();
		// c.addComplaint(complaintSubject, complaintBody);
	}

}
