public class OledDisplay implements Display {
    @Override
    public void turnOn() {
        System.out.println("OLED ON");
    }

    @Override
    public void turnOff() {
        System.out.println("OLED OFF");
    }
}
