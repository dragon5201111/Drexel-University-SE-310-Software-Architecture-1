public class PizzaDirector {
    public PizzaBuilder pizzaBuilder;

    public PizzaDirector(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void makePizza() {
        this.pizzaBuilder
                .buildPrice()
                .buildSauce()
                .buildCrust()
                .buildCheese()
                .buildToppings();
    }

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }
}
