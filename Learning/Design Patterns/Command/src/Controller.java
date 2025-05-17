public class Controller {
    Command[] commands;

    public Controller(int maxButtons) {
        commands = new Command[maxButtons];
        for (int i = 0; i < maxButtons; i++) {
            commands[i] = new NoCommand();
        }
    }

    private boolean validButton(int button) {
        return button >= 0 && button < commands.length;
    }

    public void pushButton(int button) {
        if(validButton(button)) {
            commands[button].execute();
        }
    }

    public void setButton(int button, Command command) {
        if(validButton(button)) {
            commands[button] = command;
        }
    }
}
