public class SingleCamera implements Camera {
    @Override
    public void takePicture() {
        System.out.println("Taking a single camera");
    }

    @Override
    public void startCamera() {
        System.out.println("Starting a single camera");
    }
}
