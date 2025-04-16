public abstract class GameAI {
    // Template method
    public void start(){
        this.idle();
        this.moveToNearestPlayer();
        this.speakToPlayer();
        this.doAction();
        this.idle();
    }

    // Steps
    public abstract void idle();
    public abstract void moveToNearestPlayer();
    public abstract void speakToPlayer();

    // Optional step
    // Default is to do nothing
    public void doAction(){
    }
}
