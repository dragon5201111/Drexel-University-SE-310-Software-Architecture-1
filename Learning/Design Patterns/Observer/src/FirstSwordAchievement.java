import java.util.List;

public class FirstSwordAchievement implements AchievementCondition{
    @Override
    public String getName() {
        return "First sword!";
    }

    @Override
    public boolean isUnlocked(List<Item> items) {
        return items.stream().anyMatch(item -> item instanceof Sword);
    }
}
