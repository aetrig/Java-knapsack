package knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public Result solve(int capacity) {
		Result result = new Result();
		items.sort(
				(i1, i2) -> -1 * Double.compare((double) i1.getValue() / i1.getWeight(),
						(double) i2.getValue() / i2.getWeight()));

		int i = 0;
		while (result.getWeightSum() < capacity && i < items.size()) {
			if (items.get(i).weight <= capacity - result.getWeightSum()) {
				result.addItem(items.get(i), (capacity - result.getWeightSum()) / items.get(i).weight);
			}
			i++;
		}

		return result;
	}

	@Override
	public String toString() {
		StringBuilder outBuilder = new StringBuilder();
		items.forEach(item -> outBuilder
				.append(item)
				.append("\n"));

		return outBuilder.toString();
	}
}
