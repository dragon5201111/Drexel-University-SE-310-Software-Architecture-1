public class Radio {
    boolean radioIsOn;
    float volume;
    private Station currentStation;

    public Radio(Station currentStation, float volume) {
        this.currentStation = currentStation;
        this.volume = volume;
        this.radioIsOn = true;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void turnRadioOn() {
        this.radioIsOn = true;
    }

    public void turnRadioOff() {
        this.radioIsOn = false;
    }
}
