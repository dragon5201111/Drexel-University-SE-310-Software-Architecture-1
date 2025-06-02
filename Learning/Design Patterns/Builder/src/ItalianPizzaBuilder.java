public class ItalianPizzaBuilder extends PizzaBuilder {
    public ItalianPizzaBuilder(Pizza pizza) {
        super(pizza);
    }

    @Override
    public PizzaBuilder buildPrice() {
        this.pizza.price = 7.99;
        return this;
    }

    @Override
    public PizzaBuilder buildSauce() {
        this.pizza.sauce = "red marinara sauce";
        return this;
    }

    @Override
    public PizzaBuilder buildCrust() {
        this.pizza.crust = "garlic crust";
        return this;
    }

    @Override
    public PizzaBuilder buildCheese() {
        this.pizza.cheese = "mozzarella";
        return this;
    }

    @Override
    public PizzaBuilder buildToppings() {
        this.pizza.toppings = "basil and garlic";
        return this;
    }
}
