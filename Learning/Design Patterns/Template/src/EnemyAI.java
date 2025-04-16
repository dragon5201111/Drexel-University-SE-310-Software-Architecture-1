public class EnemyAI extends GameAI{
    @Override
    public void idle() {
        System.out.println("Enemy is idle");
    }

    @Override
    public void moveToNearestPlayer() {
        System.out.println("Enemy moves to nearest player");
    }

    @Override
    public void speakToPlayer() {
        System.out.println("Enemy makes a battle cry");
    }

    @Override
    public void doAction(){
        System.out.println("Enemy hits player");
    }
}
