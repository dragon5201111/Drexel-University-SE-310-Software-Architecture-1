public class Main {
    public static void main(String[] args) {
        int i;
        int seconds;

        Radio radio = new Radio(new Station("AM", 1060), 0);
        AlarmClock alarmClock = new AlarmClock(8, 0, 0, "AM", 8, 5, "AM");

        AlarmClockRadio alarmClockRadio = new AlarmClockRadio(radio, alarmClock);
        for (i = 0; i < 6; i++)
        {
            System.out.println(alarmClockRadio.showTime());

            for ( seconds = 0; seconds < 60; seconds++)
            {
                alarmClockRadio.checkAlarm();
                alarmClockRadio.tick();
            }
        }

        alarmClockRadio.snooze();

        for (i = 0; i < 9; i++)
        {
            System.out.println(alarmClockRadio.showTime());
            for ( seconds = 0; seconds < 60; seconds++)
            {
                alarmClockRadio.checkAlarm();
                alarmClockRadio.tick();
            }
        }
        alarmClockRadio.turnAlarmOff();
        System.out.println("The alarm time is " + alarmClockRadio.getAlarmTime().getFormattedTime());
    }
}
