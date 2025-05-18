import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<InventoryItem> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        this.inventory.add(item);
    }

    public void removeItem(InventoryItem item) {
        this.inventory.remove(item);
    }

    public InventoryIterator getInventoryIterator() {
        return new InventoryIterator(this.inventory);
    }
}
