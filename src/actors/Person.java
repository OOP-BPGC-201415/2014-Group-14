package actors;

public abstract class Person {
	public static final int STUDENT = 0;
	public static final int STAFF = 1;
	
	private int designation;
	private int id;
	
	public int getDesignation() {
		return designation;
	}
	
	public int getId() {
		return id;
	}
}
