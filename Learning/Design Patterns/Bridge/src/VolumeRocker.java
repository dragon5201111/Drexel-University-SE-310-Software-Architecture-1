public class VolumeRocker implements VolumeButton{
    @Override
    public void turnUp() {
        System.out.println("Clicking up");
    }

    @Override
    public void turnDown() {
        System.out.println("Clicking down");
    }
}
