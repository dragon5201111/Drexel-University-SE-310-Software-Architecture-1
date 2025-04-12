public class CandyFactory{
    public static Candy createCandy(AbstractCandyFactory factory){
        return factory.createCandy();
    }
}
