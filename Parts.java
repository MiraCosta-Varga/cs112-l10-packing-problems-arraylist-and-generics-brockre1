public class Parts {
	private String name;
	private int quantity;
	private int partNumber;

	// Constructor
	public Parts(String name, int quantity, int partNumber) {
		this.name = name;
		this.quantity = quantity;
		this.partNumber = partNumber;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPartNumber() {
		return partNumber;
	}

	// Setters (if needed)
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}