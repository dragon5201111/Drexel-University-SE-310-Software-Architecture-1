public class Clock{
    private Time time;

    public Clock(int hour, int minutes, int seconds, String amPm) {
        this.time = new Time(hour, minutes, seconds, amPm);
    }

    public void showTime(){
        System.out.println(this.time.getTime());
    }


    public void tick(){
        this.time.incrementBySecond();
    }
}