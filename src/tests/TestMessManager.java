package tests;

import org.junit.Test;

import actors.MessManager;
import backend.DatabaseManager;

public class TestMessManager {
	private MessManager m;

	public void setUp() throws Exception {
		m = new MessManager();
	}

	@Test
	public void testAddRemoveWorker() {
	}
}
