import java.time.format.DateTimeFormatter;

public class AlarmClock extends Clock{
    private String SHUTOFF_STRING = "The alarm was shut off";

    private String SNOOZE_STRING = "Snooze was pressed";
    private final int SNOOZE_TIME = 9;

    protected Time alarmTime;
    protected Time fixedTime;
    protected boolean isAlarmOn;


    public AlarmClock(int hour, int minutes, int seconds, String amPm, int alarmHour, int alarmMinutes, String alarmAmPm) {
        super(hour, minutes, seconds, amPm);
        this.alarmTime = new Time(alarmHour, alarmMinutes, alarmAmPm);
        this.fixedTime = new Time(alarmHour, alarmMinutes, alarmAmPm);
        this.isAlarmOn = true;
    }

    public void setAlarm(Time alarmTime) {
        this.alarmTime = alarmTime;
        this.turnAlarmOn();
    }

    public boolean isAlarmOn() {
        return isAlarmOn;
    }

    public void checkAlarm(){
        if(!this.isAlarmOn()){
            return;
        }

        if(this.getCurrentTime().equals(this.alarmTime)){
            System.out.println("Buzz Buzz Buzz");
        }
    }

    public void turnAlarmOff(){
        System.out.println(SHUTOFF_STRING);
        this.isAlarmOn = false;
    }


    public void turnAlarmOn(){
        this.isAlarmOn = true;
    }

    public String showTime(){
        return this.getCurrentTime().getFormattedTime();
    }

    public void snooze(){
        System.out.println(SNOOZE_STRING);
        this.alarmTime.addMinutes(SNOOZE_TIME);
    }

}
