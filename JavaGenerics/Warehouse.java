import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private double weight;

    public WarehouseItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Weight: " + weight + "kg";
    }

    public abstract void displayItemType();
}

class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, double weight, String brand) {
        super(name, weight);
        this.brand = brand;
    }

    @Override
    public void displayItemType() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand);
    }
}

class Groceries extends WarehouseItem {
    private String category;

    public Groceries(String name, double weight, String category) {
        super(name, weight);
        this.category = category;
    }

    @Override
    public void displayItemType() {
        System.out.println("Groceries: " + getName() + ", Category: " + category);
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double weight, String material) {
        super(name, weight);
        this.material = material;
    }

    @Override
    public void displayItemType() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}

class WarehouseManager {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayItemType();
        }
    }
}
public class Warehouse{
    public static void main(String[] args) {
        Electronics phone = new Electronics("Smartphone", 0.2, "Apple");
        Groceries apple = new Groceries("Apple", 0.1, "Fruit");
        Furniture chair = new Furniture("Office Chair", 7.5, "Wood");

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(phone);

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(apple);

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(chair);

        System.out.println("Displaying all items in electronics storage:");
        WarehouseManager.displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\nDisplaying all items in groceries storage:");
        WarehouseManager.displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\nDisplaying all items in furniture storage:");
        WarehouseManager.displayAllItems(furnitureStorage.getAllItems());
    }
}