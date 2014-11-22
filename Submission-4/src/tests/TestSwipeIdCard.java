package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import actors.Student;
import backend.SwipeIdCard;

public class TestSwipeIdCard {
	private Student s1, s2, s3;

	@Test
	public void doTest() {
		Student.deleteStudent("TestID1");
		Student.deleteStudent("TestID2");
		Student.deleteStudent("TestID3");
		s1 = Student.createStudent("Test1", "TestID1", "asdlfad", 0);
		s2 = Student.createStudent("Test2", "TestID2", "asdlfad", 0);
		s3 = Student.createStudent("Test3", "TestID3", "asdlfad", 0);
		SwipeIdCard.newMeal();

		assertEquals(true, SwipeIdCard.checkMessOption(s1.getStudentId()));
		assertEquals(true, SwipeIdCard.checkMessOption(s2.getStudentId()));
		assertEquals(true, SwipeIdCard.checkMessOption(s3.getStudentId()));
		assertEquals(false, SwipeIdCard.checkMessOption("Not in the db!"));

		assertEquals(null, SwipeIdCard.validateId(s3.getStudentId()));

		assertEquals(false, SwipeIdCard.alreadyEaten(s1.getStudentId()));
		assertEquals(false, SwipeIdCard.alreadyEaten(s2.getStudentId()));
		assertEquals(true, SwipeIdCard.alreadyEaten(s3.getStudentId()));

		assertEquals(null, SwipeIdCard.validateId(s1.getStudentId()));
		assertEquals(true, SwipeIdCard.alreadyEaten(s1.getStudentId()));
		assertNotEquals(null, SwipeIdCard.validateId(s1.getStudentId()));

		long now = System.currentTimeMillis();
		long tomorrow = now + 24 * 60 * 60 * 1000;
		s2.applyForLeave(now, tomorrow);
		assertEquals(true, SwipeIdCard.isOnLeave(s2.getStudentId()));
		assertNotEquals(null, SwipeIdCard.validateId(s2.getStudentId()));

		Student.deleteStudent(s1.getStudentId());
		Student.deleteStudent(s2.getStudentId());
		Student.deleteStudent(s3.getStudentId());
	}
}
