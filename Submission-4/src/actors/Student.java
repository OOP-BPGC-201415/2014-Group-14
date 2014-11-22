package actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import web.HashGenerator;
import backend.DatabaseManager;

public class Student extends Person {
	private String studentName;
	private String studentId;
	private int messOption;
	private int dbId;

	public Student(int dbId) throws Exception {
		this.dbId = dbId;
		Connection c = DatabaseManager.getConnection();
		PreparedStatement s = c
				.prepareStatement("SELECT * FROM StudentList WHERE SR=?;");
		s.setInt(1, dbId);
		s.execute();
		ResultSet rs = s.getResultSet();
		if (!rs.first())
			throw new Exception("Student doesn't exist!");
		this.studentName = rs.getString("Name");
		this.studentId = rs.getString("Id");
		this.messOption = rs.getInt("Mess");
		s.close();
		c.close();
	}

	public Student(String id) throws Exception {
		Connection c = DatabaseManager.getConnection();
		PreparedStatement s = c
				.prepareStatement("SELECT * FROM StudentList WHERE Id=?;");
		s.setString(1, id);
		s.execute();
		ResultSet rs = s.getResultSet();
		if (!rs.first())
			throw new Exception("Student doesn't exist!");
		this.studentName = rs.getString("Name");
		this.studentId = id;
		this.messOption = rs.getInt("Mess");
		this.dbId = rs.getInt("SR");
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

	public void applyForLeave(long from, long to) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM StudentLeave WHERE Id=?;");
			s.setString(1, getStudentId());
			s.execute();
			s = c.prepareStatement("INSERT INTO StudentLeave (Id, Departure, Arrival) VALUES(?, ?, ?);");
			s.setString(1, getStudentId());
			s.setLong(2, from);
			s.setLong(3, to);
			s.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			s = c.prepareStatement("INSERT INTO Login (Hash, Id, Designation) VALUES(?, ?, ?);");
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

	public static void deleteStudent(String id) {

		try {
			Student student = new Student(id);
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM StudentList WHERE Id=?;");
			s.setString(1, student.getStudentId());
			s.execute();
			s = c.prepareStatement("DELETE FROM Login WHERE Designation=? AND Id=?;");
			s.setInt(1, 0);
			s.setInt(2, student.getId());
			s.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// Student doesn't exist.
		}
	}

	public void fillComplaint(String complaintSubject, String complaintBody) {
		/*
		 * Add Code To Implement This
		 */
		// Complaint c = new Complaint();
		// c.addComplaint(complaintSubject, complaintBody);
	}

}
