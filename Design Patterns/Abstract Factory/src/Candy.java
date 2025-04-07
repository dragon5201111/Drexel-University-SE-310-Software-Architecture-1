public abstract class Candy {
    private final String name;
    private final int sweetness;

    public Candy(String name, int sweetness) {
        this.name = name;
        this.sweetness = sweetness;
    }

    public int getSweetness() {
        return sweetness;
    }

    public String getName() {
        return name;
    }
}
