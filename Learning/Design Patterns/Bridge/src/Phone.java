public abstract class Phone {
    Display display;
    VolumeButton volumeButton;
    Camera camera;

    public Phone(Display display, VolumeButton volumeButton, Camera camera) {
        this.display = display;
        this.volumeButton = volumeButton;
        this.camera = camera;
    }

}
