public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        TV tv = new TV();
        Controller controller = new Controller(4);

        controller.setButton(0, new OnOffCommand(light));
        controller.setButton(1, new OnOffCommand(tv));

        controller.pushButton(0);
        controller.pushButton(1);

        controller.pushButton(0);
        controller.pushButton(1);

    }
}
