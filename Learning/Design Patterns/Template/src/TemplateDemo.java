public class TemplateDemo {
    public static void main(String[] args) {
        GameAI npc = new NPCAI();
        npc.start();

        GameAI enemy = new EnemyAI();
        enemy.start();
    }
}
