public class AlarmClock extends Clock {
    private final int SNOOZE_MINUTES = 9;
    private Time alarmTime;

    public AlarmClock(int hour, int minutes, int seconds, String amPm,
                      int alarmHour, int alarmMinutes, String alarmAmPm) {
        super(hour, minutes, seconds, amPm);
        this.alarmTime = new Time(alarmHour, alarmMinutes, alarmAmPm);
    }

    public void checkAlarm(){
        String alarmTime = this.alarmTime.getFormattedTime();
        String alarmClockTime = this.getTime().getFormattedTime();

        if (alarmTime.equals(alarmClockTime)) {
            System.out.println("Buzz Buzz Buzz");
        }
    }

    public void snooze(){
        System.out.println("Snooze was pressed");
        this.alarmTime.incrementByMinutes(SNOOZE_MINUTES);
    }
}
