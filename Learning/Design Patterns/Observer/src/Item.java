public abstract class Item {
    private final String name;
    private int quantity;

    public Item(String name) {
        this.name = name;
        this.quantity = 1;
    }

    public void decreaseQuantity() {
        if(this.quantity > 0) {
            this.quantity--;
        }
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
