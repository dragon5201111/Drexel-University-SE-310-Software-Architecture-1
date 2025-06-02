public class Pizza {
    public double price;
    public String sauce;
    public String crust;
    public String cheese;
    public String toppings;

    public String getDescription(){
        return String.format("Price : %.2f, Sauce: %s, Crust: %s, Cheese: %s, Toppings: %s", price, sauce, crust, cheese, toppings);
    }
}
