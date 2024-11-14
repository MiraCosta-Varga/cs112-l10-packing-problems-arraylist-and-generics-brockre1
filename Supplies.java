public class Supplies {
	private String name;
	private int quantity;

	// Constructor
	public Supplies(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	// Setters (if needed)
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}