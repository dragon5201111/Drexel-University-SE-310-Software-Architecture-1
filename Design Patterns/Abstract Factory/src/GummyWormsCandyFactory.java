public class GummyWormsCandyFactory implements AbstractCandyFactory {

    @Override
    public Candy createCandy() {
        return new GummyWorms();
    }
}
