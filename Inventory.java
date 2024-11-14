import java.util.ArrayList;

public class Inventory<T> {
	private ArrayList<T> items;

	// Constructor
	public Inventory() {
		items = new ArrayList<>();
	}

	// Add item to inventory
	public void addItem(T item) {
		items.add(item);
	}

	// Search by name (for removal or editing)
	public T searchByName(String name) {
		for (T item : items) {
			if (item instanceof Food && ((Food) item).getName().equalsIgnoreCase(name)) {
				return item;
			} else if (item instanceof Parts && ((Parts) item).getName().equalsIgnoreCase(name)) {
				return item;
			} else if (item instanceof Supplies && ((Supplies) item).getName().equalsIgnoreCase(name)) {
				return item;
			}
		}
		return null;
	}

	// Remove item from inventory
	public void removeItem(T item) {
		items.remove(item);
	}

	// Check or edit quantity
	public void checkQty(String name, int newQty) {
		T item = searchByName(name);
		if (item instanceof Food) {
			((Food) item).setQuantity(newQty);
		} else if (item instanceof Parts) {
			((Parts) item).setQuantity(newQty);
		} else if (item instanceof Supplies) {
			((Supplies) item).setQuantity(newQty);
		}
	}
}