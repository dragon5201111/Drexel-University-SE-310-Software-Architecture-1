public class SkittlesCandyFactory implements AbstractCandyFactory{
    @Override
    public Candy createCandy() {
        return new Skittles();
    }
}
