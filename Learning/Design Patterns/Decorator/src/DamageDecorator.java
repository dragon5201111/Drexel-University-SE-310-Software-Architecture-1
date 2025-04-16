public class DamageDecorator extends UpgradeDecorator {
    public DamageDecorator(Character character) {
        super(character);
    }

    @Override
    public double getDamage() {
        return super.getDamage() * 2;
    }
}
