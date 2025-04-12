public class EmailStrategy implements OrderNotificationStrategy {
    @Override
    public void sendNotification() {
        System.out.println("Sending email...");
    }
}
