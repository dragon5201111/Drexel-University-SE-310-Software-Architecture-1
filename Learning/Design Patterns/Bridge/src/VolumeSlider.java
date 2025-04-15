public class VolumeSlider implements VolumeButton{
    @Override
    public void turnUp() {
        System.out.println("Sliding Up");
    }

    @Override
    public void turnDown() {
        System.out.println("Sliding Down");
    }
}
