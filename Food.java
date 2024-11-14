public class Food {
	private String name;
	private int quantity;
	private boolean perishable;

	// Constructor
	public Food(String name, int quantity, boolean perishable) {
		this.name = name;
		this.quantity = quantity;
		this.perishable = perishable;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean getPerishable() {
		return perishable;
	}

	// Setters (if needed)
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}