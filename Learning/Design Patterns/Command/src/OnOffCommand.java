public class OnOffCommand implements Command{
    private final Device device;

    public OnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.toggle();
    }
}
