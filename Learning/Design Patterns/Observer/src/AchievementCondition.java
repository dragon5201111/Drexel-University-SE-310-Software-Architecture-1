import java.util.List;

public interface AchievementCondition {
    String getName();
    boolean isUnlocked(List<Item> items);
}
