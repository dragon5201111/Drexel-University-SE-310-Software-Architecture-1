public class Radio {
    private final String DEFAULT_AMPLITUDE = "AM";
    private final int DEFAULT_STATION = 1060;
    private final int DEFAULT_VOLUME = 0;

    private int station;
    private String amplitude;
    private int volume;

    public Radio(){
        this.station = DEFAULT_STATION;
        this.amplitude = DEFAULT_AMPLITUDE;
        this.volume = DEFAULT_VOLUME;
    }

    public Radio(String amplitude, int station, int volume) {
        this.station = station;
        this.amplitude = amplitude;
        this.volume = volume;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
