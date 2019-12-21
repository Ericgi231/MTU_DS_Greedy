package cs2321;

import org.junit.Before;
import org.junit.Test;

public class FractionalKnapsackTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testMaximumValue() {
		int[][] items = {{4,12},{8,32},{2,40},{6,30},{1,50}};
		org.junit.Assert.assertEquals(124, FractionalKnapsack.MaximumValue(items,10), 0.01);
	}
	
	@Test
	public void testMaximumValueExtra1() {
		int[][] items = {{20,60},{50,100},{30,120}};
		org.junit.Assert.assertEquals(180, FractionalKnapsack.MaximumValue(items,50), 0.01);
	}
	
	@Test
	public void testMaximumValueExtra2() {
		int[][] items = {{4,12}};
		org.junit.Assert.assertEquals(12, FractionalKnapsack.MaximumValue(items,10), 0.01);
	}
	
	@Test
	public void testMaximumValueExtra3() {
		int[][] items = {{4,10}};
		org.junit.Assert.assertEquals(7.5, FractionalKnapsack.MaximumValue(items,3), 0.01);
	}
	
	@Test
	public void testMaximumValueExtra4() {
		int[][] items = {{4,12},{8,32},{2,30},{6,40},{1,50}};
		org.junit.Assert.assertEquals(124, FractionalKnapsack.MaximumValue(items,10), 0.01);
	}

}
