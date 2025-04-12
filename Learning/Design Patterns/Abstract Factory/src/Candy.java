public abstract class Candy {
    private final CandyName name;
    private final CandySweetness sweetness;
    private boolean consumed;

    public Candy(CandyName name, CandySweetness sweetness) {
        this.name = name;
        this.sweetness = sweetness;
        this.consumed = false;
    }

    public CandySweetness getSweetness() {
        return sweetness;
    }

    public CandyName getName() {
        return this.name;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void consume(){
        if(!consumed){
            consumed = true;
        }
    }
}
