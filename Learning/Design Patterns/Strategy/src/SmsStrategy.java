public class SmsStrategy implements OrderNotificationStrategy{
    @Override
    public void sendNotification() {
        System.out.println("Sending SMS...");
    }
}
