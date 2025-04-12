public class OrderNotifier {
    public void sendNotification(OrderNotificationStrategy strategy) {
        strategy.sendNotification();
    }
}
