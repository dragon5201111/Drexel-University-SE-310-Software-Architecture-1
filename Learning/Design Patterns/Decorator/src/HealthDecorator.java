public class HealthDecorator extends UpgradeDecorator{
    public HealthDecorator(Character character) {
        super(character);
    }

    @Override
    public int getHealth() {
        return super.getHealth() * 2;
    }
}
