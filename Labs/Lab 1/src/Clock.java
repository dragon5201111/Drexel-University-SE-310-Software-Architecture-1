public class Clock{
    protected Time currentTime;

    public Clock(int hour, int minutes, int seconds, String amPm){
        this.currentTime = new Time(hour, minutes, seconds, amPm);
    }

    public void tick(){
        this.currentTime.addSecond();
    }

    public Time getCurrentTime(){
        return this.currentTime;
    }

    public void setCurrentTime(Time currentTime){
        this.currentTime = currentTime;
    }
}