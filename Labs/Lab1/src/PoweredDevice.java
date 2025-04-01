public abstract class PoweredDevice {
    private boolean turnedOn = true;

    public void turnOff(){
        this.turnedOn = false;
    }
    public void turnOn(){
        this.turnedOn = true;
    }
}
