public class GummyWormsFactory implements AbstractCandyFactory {

    @Override
    public Candy createCandy() {
        return new GummyWorms();
    }
}
