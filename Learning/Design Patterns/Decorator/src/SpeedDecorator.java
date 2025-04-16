public class SpeedDecorator extends UpgradeDecorator{
    public SpeedDecorator(Character character) {
        super(character);
    }

    @Override
    public double getSpeed() {
        return super.getSpeed() + 5;
    }
}
