public class Main {
    public static void main(String[] args) {
        CheesePizzaBuilder cheesePizzaBuilder = new CheesePizzaBuilder(new Pizza());
        ItalianPizzaBuilder italianPizzaBuilder = new ItalianPizzaBuilder(new Pizza());

        PizzaDirector pizzaDirector = new PizzaDirector(cheesePizzaBuilder);
        pizzaDirector.makePizza();

        pizzaDirector.setPizzaBuilder(italianPizzaBuilder);
        pizzaDirector.makePizza();

        System.out.println(italianPizzaBuilder.getPizza().getDescription());
        System.out.println(cheesePizzaBuilder.getPizza().getDescription());
    }
}
