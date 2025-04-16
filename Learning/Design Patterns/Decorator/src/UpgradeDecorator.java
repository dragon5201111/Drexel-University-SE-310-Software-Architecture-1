public class UpgradeDecorator extends Character{
    protected Character character;

    public UpgradeDecorator(Character character) {
        this.character = character;
    }

    @Override
    public int getHealth() {
        return character.getHealth();
    }

    @Override
    public double getDamage() {
        return character.getDamage();
    }

    @Override
    public double getSpeed() {
        return character.getSpeed();
    }

}
