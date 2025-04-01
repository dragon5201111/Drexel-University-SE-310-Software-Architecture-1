import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AlarmClock extends PoweredDevice{
    private LocalTime time;
    DateTimeFormatter timeFormatter;

    public AlarmClock(int hour, int minute, int second, String ampm) {
        this.time = LocalTime.of(hour, minute, second);
        this.timeFormatter = DateTimeFormatter.ofPattern("h:mm:ss a");
    }

    public void tick(){
        this.time = this.time.plusSeconds(1);
    }
}
