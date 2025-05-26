package knapsack;

import org.junit.Test;

import org.junit.Assert;

public class ProblemTest {
	@Test
	public void numberCountTest() {
		Problem p = new Problem(5, 1, 10, 20);
		Assert.assertEquals(5, p.items.size());
	}

}
