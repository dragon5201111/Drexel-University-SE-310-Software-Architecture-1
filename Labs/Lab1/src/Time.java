import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private static final String PM = "PM";
    private LocalTime time;

    public Time(int hour, int minutes, String amPm) {
        this(hour, minutes, 0, amPm);
    }

    public Time(int hour, int minutes, int seconds, String amPm) {
        if(amPm.equals(PM)) {
            hour += 12;
        }

        this.time = LocalTime.of(hour, minutes, seconds);
    }

    public String getTime(){
        return this.time.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    public void incrementBySecond(){
        this.time = this.time.plusSeconds(1);
    }
}
