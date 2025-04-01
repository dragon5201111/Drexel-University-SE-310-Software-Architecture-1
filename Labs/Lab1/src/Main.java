public class Main {
    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock(12,0, 59, "AM", 12, 1, "AM");
        alarmClock.tick();
        alarmClock.checkAlarm();

    }
}
