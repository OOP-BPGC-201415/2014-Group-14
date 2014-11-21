package web;


public class Session {
	public int designation, id;
	public long timestamp;
	public String hash;

	public Session(int id, int designation, long timestamp, String hash) {
		this.designation = designation;
		this.id = id;
		this.timestamp = timestamp;
		this.hash = hash;
	}
}
