package IO;

import java.io.Serializable;

public abstract class InputDriver implements Serializable {
    public abstract String getStringInput(String prompt);
    public abstract int getIntegerInput(String prompt);
    public abstract int getIntegerInput(String prompt, int max);
}
