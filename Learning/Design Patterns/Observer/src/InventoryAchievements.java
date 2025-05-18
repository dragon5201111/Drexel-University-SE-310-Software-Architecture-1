import java.util.HashMap;
import java.util.List;

public class InventoryAchievements extends InventoryObserver{
    private final HashMap<AchievementCondition, Boolean> achievements;

    public InventoryAchievements(List<Item> items) {
        super(items);
        this.achievements = new HashMap<>();
    }

    public void addCondition(AchievementCondition condition) {
        this.achievements.put(condition, false);
    }


    @Override
    void update() {
        for(AchievementCondition condition : this.achievements.keySet()) {
            if(this.achievements.get(condition)) {
                continue;
            }

            if(condition.isUnlocked(this.items)){
                this.achievements.put(condition, true);
                System.out.println("Achievement unlocked: " + condition.getName());
            }
        }
    }
}
