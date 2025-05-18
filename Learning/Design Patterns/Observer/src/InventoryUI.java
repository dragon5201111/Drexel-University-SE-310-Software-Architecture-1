import java.util.List;

public class InventoryUI extends InventoryObserver{
    public InventoryUI(List<Item> items) {
        super(items);
    }

    @Override
    public void update() {
        System.out.println("Updating UI...");
        this.displayItems();
    }

    public void displayItems(){
        for(Item item : items){
            this.displayItem(item);
        }

        System.out.println();
    }

    public void displayItem(Item item){
        String itemName = item.getName();
        int itemQuantity = item.getQuantity();

        System.out.println(itemName + " : " + itemQuantity);
    }

}
