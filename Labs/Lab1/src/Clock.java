import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Clock{
    private LocalTime time;
    private DateTimeFormatter timeFormatter;

    public Clock(int hour, int minute, int second) {
        this.time = LocalTime.of(hour, minute, second);
        this.timeFormatter = DateTimeFormatter.ofPattern("h:mm:ss a");
    }

    public void tick(){
        this.time = this.time.plusSeconds(1);
    }
}
