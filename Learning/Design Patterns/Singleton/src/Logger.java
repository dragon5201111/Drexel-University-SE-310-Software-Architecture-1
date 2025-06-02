public class Logger {
    private static Logger logger;
    private static String logType;

    private Logger() {
        Logger.logType = "[DEFAULT]";
    }

    public static Logger getInstance(){
        if(Logger.logger == null){
            Logger.logger = new Logger();
        }

        return Logger.logger;
    }

    public void log(String msg){
        System.out.println(Logger.logType + " " + msg);
    }

    public void setLogType(String logType){
        Logger.logType = "[" + logType + "]";
    }
}
