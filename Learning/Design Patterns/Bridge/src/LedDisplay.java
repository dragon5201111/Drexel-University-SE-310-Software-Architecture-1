public class LedDisplay implements Display {
    @Override
    public void turnOn() {
        System.out.println("LED ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LED OFF");
    }
}
