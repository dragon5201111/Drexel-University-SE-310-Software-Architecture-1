public class SkittlesFactory implements AbstractCandyFactory{
    @Override
    public Candy createCandy() {
        return new Skittles();
    }
}
