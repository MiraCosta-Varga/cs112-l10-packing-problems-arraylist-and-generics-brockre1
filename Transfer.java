import java.util.ArrayList;
import java.util.Scanner;

public class Transfer {
  Setup setup = new Setup();
  Food[] foodArray = setup.getFoodArray();
  Parts[] partsArray = setup.getPartsArray();
  Supplies[] suppliesArray = setup.getSuppliesArray();

  ArrayList<Food> foodList = new ArrayList<>();
  ArrayList<Parts> partsList = new ArrayList<>();
  ArrayList<Supplies> suppliesList = new ArrayList<>();

  Inventory<Food> foodInventory = new Inventory<>();
  Inventory<Parts> partsInventory = new Inventory<>();
  Inventory<Supplies> suppliesInventory = new Inventory<>();

  public Transfer() {
    for (Food food : foodArray) foodList.add(food);
    for (Parts part : partsArray) partsList.add(part);
    for (Supplies supply : suppliesArray) suppliesList.add(supply);
  }

  public void addItems(int listNumber) {
    Scanner keyboard = new Scanner(System.in);
    if (listNumber == 1) {
      System.out.print("Food name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();
      keyboard.nextLine();
      System.out.print("Perishable? (T/F): ");
      boolean perishable = keyboard.nextLine().equalsIgnoreCase("T");

      Food newFoodItem = new Food(name, qty, perishable);
      foodList.add(newFoodItem);
      foodInventory.addItem(newFoodItem);
      System.out.println("Food item added successfully!");

    } else if (listNumber == 2) {
      System.out.print("Part name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();
      System.out.print("Part Number (5-digit): ");
      int pn = keyboard.nextInt();

      Parts newPartsItem = new Parts(name, qty, pn);
      partsList.add(newPartsItem);
      partsInventory.addItem(newPartsItem);
      System.out.println("Parts item added successfully!");

    } else if (listNumber == 3) {
      System.out.print("Supplies name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();

      Supplies newSuppliesItem = new Supplies(name, qty);
      suppliesList.add(newSuppliesItem);
      suppliesInventory.addItem(newSuppliesItem);
      System.out.println("Supplies item added successfully!");
    }
  }

  public void removeItems(int listNumber) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Name of Item to be Removed: ");
    String name = keyboard.nextLine();

    if (listNumber == 1) {
      Food item = foodInventory.searchByName(name);
      if (item != null) {
        foodList.remove(item);
        foodInventory.removeItem(item);
        System.out.println("Food item removed successfully!");
      }

    } else if (listNumber == 2) {
      Parts item = partsInventory.searchByName(name);
      if (item != null) {
        partsList.remove(item);
        partsInventory.removeItem(item);
        System.out.println("Parts item removed successfully!");
      }

    } else if (listNumber == 3) {
      Supplies item = suppliesInventory.searchByName(name);
      if (item != null) {
        suppliesList.remove(item);
        suppliesInventory.removeItem(item);
        System.out.println("Supplies item removed successfully!");
      }
    }
  }

  public void editQuantity(int listNumber) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Name of Item to Edit: ");
    String name = keyboard.nextLine();
    System.out.print("Desired Quantity: ");
    int desiredQty = keyboard.nextInt();

    if (listNumber == 1) {
      foodInventory.checkQty(name, desiredQty);
      System.out.println("Food quantity updated!");

    } else if (listNumber == 2) {
      partsInventory.checkQty(name, desiredQty);
      System.out.println("Parts quantity updated!");

    } else if (listNumber == 3) {
      suppliesInventory.checkQty(name, desiredQty);
      System.out.println("Supplies quantity updated!");
    }
  }
  public void printLists() {
    if (foodList.isEmpty() && partsList.isEmpty() && suppliesList.isEmpty()) {
      System.out.println("\nNo items found in any list.");
      return;
    }

    // Print food list if it's not empty
    if (!foodList.isEmpty()) {
      System.out.println("\nFOOD");
      System.out.println("----------------------------------------------");
      System.out.printf("%-25s %-15s %-10s%n", "Name", "Perishable", "Quantity");
      System.out.println("----------------------------------------------");
      for (Food food : foodList) {
        System.out.printf("%-25s %-15s %-10d%n", food.getName(), food.getPerishable() ? "Yes" : "No", food.getQuantity());
      }
    }

    // Print parts list if it's not empty
    if (!partsList.isEmpty()) {
      System.out.println("\nPARTS");
      System.out.println("----------------------------------------------");
      System.out.printf("%-25s %-15s %-10s%n", "Name", "Part Number", "Quantity");
      System.out.println("----------------------------------------------");
      for (Parts part : partsList) {
        System.out.printf("%-25s %-15d %-10d%n", part.getName(), part.getPartNumber(), part.getQuantity());
      }
    }

    // Print supplies list if it's not empty
    if (!suppliesList.isEmpty()) {
      System.out.println("\nSUPPLIES");
      System.out.println("----------------------------------------------");
      System.out.printf("%-25s %-15s%n", "Name", "Quantity");
      System.out.println("----------------------------------------------");
      for (Supplies supply : suppliesList) {
        System.out.printf("%-25s %-15d%n", supply.getName(), supply.getQuantity());
      }
    }
  }
}