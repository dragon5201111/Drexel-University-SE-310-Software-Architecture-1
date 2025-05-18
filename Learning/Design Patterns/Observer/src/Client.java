import java.util.ArrayList;
import java.util.List;

public class Client {


    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        InventorySystem inventorySystem = new InventorySystem(items);

        InventoryAchievements inventoryAchievements = new InventoryAchievements(items);
        inventoryAchievements.addCondition(new FirstSwordAchievement());
        inventoryAchievements.addCondition(new FifthSwordAchievement());
        inventoryAchievements.addCondition(new CoinPorkChopAchievement());

        inventorySystem.registerObserver(new InventoryUI(items));
        inventorySystem.registerObserver(inventoryAchievements);

        inventorySystem.addItem(new PorkChop());
        inventorySystem.addItem(new PorkChop());
        inventorySystem.addItem(new Sword());

        inventorySystem.decreaseQuantity(0);

        inventorySystem.increaseQuantity(2);
        inventorySystem.increaseQuantity(2);
        inventorySystem.increaseQuantity(2);
        inventorySystem.increaseQuantity(2);
        inventorySystem.increaseQuantity(2);

        inventorySystem.addItem(new Coin());

    }
}
