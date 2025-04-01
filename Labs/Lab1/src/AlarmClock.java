public class AlarmClock extends Clock {
    Time alarmTime;

    public AlarmClock(int hour, int minutes, int seconds, String amPm,
                      int alarmHour, int alarmMinutes, String alarmAmPm) {
        super(hour, minutes, seconds, amPm);
        this.alarmTime = new Time(alarmHour, alarmMinutes, alarmAmPm);
    }
}
