public class Station {
    private String modulation;
    private int channel;

    public Station(String modulation, int channel) {
        this.modulation = modulation;
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }



}
