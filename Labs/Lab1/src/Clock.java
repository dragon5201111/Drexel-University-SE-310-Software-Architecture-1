public class Clock{
    private final Time time;

    public Clock(int hour, int minutes, int seconds, String amPm) {
        this.time = new Time(hour, minutes, seconds, amPm);
    }

    public Time getTime() {
        return this.time;
    }

    public String showTime(){
        return this.time.getFormattedTime();
    }


    public void tick(){
        this.time.incrementBySecond();
    }

}