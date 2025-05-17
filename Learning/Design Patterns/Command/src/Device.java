public abstract class Device {
    public String name;
    private boolean on;

    public Device(String name) {
        this.name = name;
        this.on = false;
    }

    public boolean isOn(){
        return this.on;
    }

    public void on() {
        this.on = true;
    }

    public void off() {
        this.on = false;
    }

    public void toggle() {
        if(this.isOn()){
            System.out.println(name + " was toggled off");
            this.off();
        }else{
            System.out.println(name + " was toggled on");
            this.on();
        }
    }
}
