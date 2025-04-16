public abstract class Character {
    private final int health = 100;
    private final double damage = 5;
    private final double speed = 1.5;

    public int getHealth() {
        return this.health;
    }

    public double getDamage(){
        return this.damage;
    }

    public double getSpeed(){
        return this.speed;
    }

    public void displayStats(){
        System.out.println("Health: " + this.getHealth());
        System.out.println("Damage: " + this.getDamage());
        System.out.println("Speed: " + this.getSpeed());
        System.out.println();
    }
}
