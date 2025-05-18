import java.util.List;

public abstract class InventoryObserver {
    protected List<Item> items;

    public InventoryObserver(List<Item> items) {
        this.items = items;
    }

    abstract void update();
}
