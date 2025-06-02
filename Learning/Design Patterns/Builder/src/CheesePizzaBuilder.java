public class CheesePizzaBuilder extends PizzaBuilder {
    public CheesePizzaBuilder(Pizza pizza) {
        super(pizza);
    }

    @Override
    public PizzaBuilder buildPrice() {
        this.pizza.price = 5.99;
        return this;
    }

    @Override
    public PizzaBuilder buildSauce() {
        this.pizza.sauce = "tomato sauce";
        return this;
    }

    @Override
    public PizzaBuilder buildCrust() {
        this.pizza.crust = "regular";
        return this;
    }

    @Override
    public PizzaBuilder buildCheese() {
        this.pizza.cheese = "mozzarella";
        return this;
    }

    @Override
    public PizzaBuilder buildToppings() {
        this.pizza.toppings = "none";
        return this;
    }
}
