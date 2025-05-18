import java.util.List;

public class FifthSwordAchievement implements AchievementCondition{
    @Override
    public String getName() {
        return "Five swords!";
    }

    @Override
    public boolean isUnlocked(List<Item> items) {
        return items.stream().anyMatch(item -> item instanceof Sword && item.getQuantity() >= 5);
    }
}
