package IO;

public abstract class InputDriver{

    public abstract String getStringInput(String prompt);
    public abstract int getIntegerInput(String prompt);
    public abstract int getIntegerInput(String prompt, int max);
}
