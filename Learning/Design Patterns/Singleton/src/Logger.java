public class Logger {
    private static Logger logger;
    private String logType;

    private Logger() {
        this.logType = "[DEFAULT]";
    }

    public static Logger getInstance(){
        // Lock this Logger class
        synchronized (Logger.class) {
            if(Logger.logger == null){
                Logger.logger = new Logger();
            }
        }

        return Logger.logger;
    }

    public synchronized void log(String msg){
        System.out.println(this.logType + " " + msg);
    }

    public synchronized void setLogType(String logType){
        this.logType = "[" + logType + "]";
    }
}
