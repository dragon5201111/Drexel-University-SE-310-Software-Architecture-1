public class DualCamera implements Camera {
    @Override
    public void takePicture() {
        System.out.println("Taking dual-camera image");
    }

    @Override
    public void startCamera() {
        System.out.println("Starting dual-camera");
    }
}
