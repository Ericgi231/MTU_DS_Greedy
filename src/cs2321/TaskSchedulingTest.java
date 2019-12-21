package cs2321;

import org.junit.Before;
import org.junit.Test;

public class TaskSchedulingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNumOfMachines() {
		int[][] tasks = {{1,4},{1,3},{2,5},{3,7},{4,7},{6,9},{7,8}};
		org.junit.Assert.assertEquals(3, TaskScheduling.NumOfMachines(tasks), 0.01);
	}
	
	@Test
	public void testNumOfMachinesExtra1() {
		int[][] tasks = {{0,1},{0,1},{0,3},{1,3},{3,4},{3,6},{2,8},{3,8},{6,8},{2,4},{4,5},{7,8}};
		org.junit.Assert.assertEquals(5, TaskScheduling.NumOfMachines(tasks), 0.01);
	}
}
