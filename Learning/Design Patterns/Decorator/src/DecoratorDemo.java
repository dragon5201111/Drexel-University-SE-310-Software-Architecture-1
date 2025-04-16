public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("Base Character: ");
        Character character = new BaseCharacter();
        character.displayStats();

        System.out.println("Adding 4x Health: ");
        character = new HealthDecorator(new HealthDecorator(character));
        character.displayStats();

        System.out.println("Adding 2x Damage:");
        character = new DamageDecorator(character);
        character.displayStats();
    }
}
