import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time{
    private static final String PM = "PM";
    private static final String AM = "AM";

    private LocalTime time;

    public Time(int hour, int minutes, String amPm) {
        this(hour, minutes, 0, amPm);
    }

    public Time(int hour, int minutes, int seconds, String amPm) {
        if (amPm.equals(PM) && hour != 12) {
            hour += 12;
        }else if(amPm.equals(AM) && hour == 12) {
            hour = 0;
        }

        this.time = LocalTime.of(hour, minutes, seconds);
    }

    public void addSecond(){
        this.time = this.time.plusSeconds(1);
    }

    public void addMinutes(int minutes){
        this.time = this.time.plusMinutes(minutes);
    }

    public String getFormattedTime(){
        return this.time.format(DateTimeFormatter.ofPattern("h:mm:ss a"));
    }

    public boolean equals(Time other){
        return this.getFormattedTime().equals(other.getFormattedTime());
    }

}
