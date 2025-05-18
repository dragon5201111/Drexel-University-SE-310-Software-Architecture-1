public class Client {
    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        myInventory.addItem(new InventoryItem("Running Shoes", "worn running shoes"));
        myInventory.addItem(new InventoryItem("Orange", "a ripe orange"));
        myInventory.addItem(new InventoryItem("Pearl", "a shiny pearl"));

        InventoryIterator inventoryIterator = myInventory.getInventoryIterator();

        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            System.out.printf("%s : %s\n", inventoryItem.itemName(), inventoryItem.itemDescription());
        }
    }
}
