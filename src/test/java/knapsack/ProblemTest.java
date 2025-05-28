package knapsack;

import org.junit.Test;

import org.junit.Assert;

public class ProblemTest {
	@Test
	public void numberCountTest() {
		Problem p = new Problem(5, 1, 10, 20);
		Assert.assertEquals(5, p.items.size());
	}

	@Test
	public void atLeastOneTest() {
		Problem p = new Problem(10, 1, 1, 20);
		Result result = p.solve(10);
		boolean isAtLeastOneWithinCapacity = false;
		for (int i = 0; i < p.itemCount; i++) {
			if (p.items.get(i).weight <= 10) {
				isAtLeastOneWithinCapacity = true;
			}
		}
		if (isAtLeastOneWithinCapacity) {
			Assert.assertTrue(result.items.size() > 0);
		}
	}

	@Test
	public void emptyTest() {
		Problem p = new Problem(10, 1, 15, 20);
		int capacity = 10;
		Result result = p.solve(capacity);
		boolean isAtLeastOneWithinCapacity = false;
		for (int i = 0; i < p.itemCount; i++) {
			if (p.items.get(i).weight <= capacity) {
				isAtLeastOneWithinCapacity = true;
			}
		}
		if (!isAtLeastOneWithinCapacity) {
			Assert.assertEquals(0, result.items.size());
		}
	}

	@Test
	public void allInRange() {
		int lowerBound = 5;
		int upperBound = 10;
		Problem p = new Problem(10, 1, lowerBound, upperBound);
		boolean allInRange = true;
		for (int i = 0; i < p.itemCount; i++) {
			int weight = p.items.get(i).weight;
			int value = p.items.get(i).value;
			if (weight > upperBound) {
				allInRange = false;
			}
			if (weight < lowerBound) {
				allInRange = false;
			}
			if (value > upperBound) {
				allInRange = false;
			}
			if (value < lowerBound) {
				allInRange = false;
			}
		}
		Assert.assertTrue(allInRange);
	}

	@Test
	public void specificInstance() {
		Problem p = new Problem(10, 1, 1, 10);
		Result result = p.solve(15);
		Assert.assertArrayEquals(new int[] { 15, 33 }, new int[] { result.getWeightSum(), result.getValueSum() });
	}
}
