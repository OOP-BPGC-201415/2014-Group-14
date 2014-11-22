package actors;

public abstract class Person {
	public static final int STUDENT = 0;
	public static final int STAFF = 1;
	
	public abstract int getDesignation();
	
	public abstract int getId();
}
