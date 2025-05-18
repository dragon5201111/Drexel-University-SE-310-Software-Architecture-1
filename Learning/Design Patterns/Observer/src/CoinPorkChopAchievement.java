import java.util.List;

public class CoinPorkChopAchievement implements AchievementCondition{
    @Override
    public String getName() {
        return "Coin and Pork Chop";
    }

    @Override
    public boolean isUnlocked(List<Item> items) {
        boolean hasPorkChop = items.stream().anyMatch(item -> item instanceof PorkChop);
        boolean hasCoin = items.stream().anyMatch(item -> item instanceof Coin);
        return hasPorkChop && hasCoin;
    }
}
