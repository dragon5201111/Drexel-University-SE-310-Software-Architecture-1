import java.util.Iterator;
import java.util.List;

public class InventoryIterator implements Iterator<InventoryItem> {
    private final List<InventoryItem> inventory;

    public InventoryIterator(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean hasNext() {
        return !this.inventory.isEmpty();
    }

    @Override
    public InventoryItem next() {
        return this.inventory.removeFirst();
    }
}
