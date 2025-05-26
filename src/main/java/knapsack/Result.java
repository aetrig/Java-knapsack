package knapsack;

import java.util.ArrayList;
import java.util.List;

public class Result {
	List<Pair<Item, Integer>> items = new ArrayList<Pair<Item, Integer>>();
	int weightSum = 0;
	int valueSum = 0;

	public void addItem(Item item, int count) {

		boolean foundItem = false;
		int i = 0;
		while (!foundItem && i < items.size()) {
			if (items.get(i).I1 == item) {
				items.get(i).I2 += count;
				foundItem = true;
			}
			i++;
		}
		if (!foundItem) {
			items.add(new Pair<Item, Integer>(item, count));
		}
		weightSum += item.weight * count;
		valueSum += item.value * count;
	}

	@Override
	public String toString() {
		StringBuilder outBuilder = new StringBuilder();
		outBuilder
				.append("Weight: ")
				.append(weightSum)
				.append(" Value: ")
				.append(valueSum)
				.append("\n");

		items.forEach(item -> outBuilder
				.append(item.I1)
				.append(" count: ")
				.append(item.I2)
				.append("\n"));

		return outBuilder.toString();
	}

	public int getValueSum() {
		return valueSum;
	}

	public int getWeightSum() {
		return weightSum;
	}
}
