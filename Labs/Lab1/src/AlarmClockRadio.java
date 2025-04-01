public class AlarmClockRadio {
    private Radio radio;
    private AlarmClock alarmClock;

    public AlarmClockRadio(Radio radio, AlarmClock alarmClock) {
        this.radio = radio;
        this.alarmClock = alarmClock;
    }

    public String getRadioStation(){
        Station currentStation = radio.getCurrentStation();
        return currentStation.getChannel() + " " + currentStation.getModulation();
    }

    public void setRadioStation(Station station) {
        this.radio.setCurrentStation(station);
    }


    public void setAlarmTime(Time alarmTime) {
        this.alarmClock.setAlarm(alarmTime);
    }

    public Time getCurrentTime() {
        return this.alarmClock.getCurrentTime();
    }

    public void setCurrentTime(Time currentTime) {
        this.alarmClock.setCurrentTime(currentTime);
    }

    public Time getAlarmTime(){
        return this.alarmClock.fixedTime;
    }

    public void turnAlarmOn(){
        this.alarmClock.turnAlarmOn();
    }

    public void turnAlarmOff(){
        this.radio.turnRadioOff();
        this.alarmClock.turnAlarmOff();
    }

    public void snooze(){
        this.radio.turnRadioOff();
        this.alarmClock.snooze();
    }

    public void tick(){
        this.alarmClock.tick();
    }

    public String showTime(){
        return this.alarmClock.showTime();
    }

    public void checkAlarm(){
        if(!this.alarmClock.isAlarmOn()){
            return;
        }

        if(this.getCurrentTime().equals(this.alarmClock.alarmTime)){
            this.radio.turnRadioOn();
            System.out.println("The radio is playing " + this.getRadioStation());
        }
    }

}
