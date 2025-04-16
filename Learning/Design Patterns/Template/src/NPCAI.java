public class NPCAI extends GameAI{
    @Override
    public void idle() {
        System.out.println("NPC is idle");
    }

    @Override
    public void moveToNearestPlayer() {
        System.out.println("Npc walks towards nearest player");
    }

    @Override
    public void speakToPlayer() {
        System.out.println("Npc says hi to player");
    }
}
