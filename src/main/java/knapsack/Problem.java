package knapsack;

import java.util.*;

public class Problem {
	int itemCount;
	long seed;
	int lowerBound;
	int upperBound;
	List<Item> items;

	public Problem(int itemCount, long seed, int lowerBound, int upperBound) {
		this.itemCount = itemCount;
		this.seed = seed;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		Random rand = new Random(seed);
		items = new ArrayList<Item>();
		for (int i = 0; i < itemCount; i++) {
			items.add(new Item(rand.nextInt(upperBound + 1 - lowerBound) + lowerBound,
					rand.nextInt(upperBound + 1 - lowerBound) + lowerBound));
		}
	}

	public void printItems() {
		items.forEach(item -> System.out.printf("%d %d \n", item.weight, item.value));
	}

	@Override
	public String toString() {
		StringBuilder outBuilder = new StringBuilder();
		items.forEach(item -> outBuilder
				.append("w: ")
				.append(item.weight)
				.append(" v: ")
				.append(item.value)
				.append("\n"));

		return outBuilder.toString();
	}
}
