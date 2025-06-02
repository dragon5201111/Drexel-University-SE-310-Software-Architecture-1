public abstract class PizzaBuilder {
    public Pizza pizza;

    public PizzaBuilder(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract PizzaBuilder buildPrice();
    public abstract PizzaBuilder buildSauce();
    public abstract PizzaBuilder buildCrust();
    public abstract PizzaBuilder buildCheese();
    public abstract PizzaBuilder buildToppings();

    public void resetPizza(){
        this.pizza = new Pizza();
    }

    public Pizza getPizza() {
        return this.pizza;
    }


}
