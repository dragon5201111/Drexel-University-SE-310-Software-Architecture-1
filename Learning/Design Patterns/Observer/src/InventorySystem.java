import java.util.ArrayList;
import java.util.List;

public class InventorySystem implements InventorySubject{
    private final List<Item> items;
    private final List<InventoryObserver> observers;

    public InventorySystem(List<Item> items) {
        this.observers = new ArrayList<>();
        this.items = items;
    }

    @Override
    public void registerObserver(InventoryObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(InventoryObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(InventoryObserver observer : observers) {
            observer.update();
        }
    }

    public void addItem(Item item) {
        items.add(item);
        this.notifyObservers();
    }

    public void removeItem(Item item) {
        items.remove(item);
        this.notifyObservers();
    }

    public void increaseQuantity(int index) {
        this.items.get(index).increaseQuantity();
        this.notifyObservers();
    }

    public void decreaseQuantity(int index) {
        this.items.get(index).decreaseQuantity();
        this.notifyObservers();
    }

    public List<Item> getItems() {
        return this.items;
    }

}
