package knapsack;

public class Item {
	int weight;
	int value;

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

	public Item(int value, int weight) {
		this.weight = weight;
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder outBuilder = new StringBuilder();
		outBuilder
				.append("v: ")
				.append(value)
				.append(" w: ")
				.append(weight);
		return outBuilder.toString();
	}
}
