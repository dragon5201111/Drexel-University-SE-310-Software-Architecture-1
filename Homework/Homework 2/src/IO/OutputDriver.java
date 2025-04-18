package IO;

import java.util.List;

public abstract class OutputDriver {
    public abstract void println(String s);
    public abstract void print(String s);
    public abstract void printLines(List<String> lines);
    public abstract void printLines(List<String> lines, int startIndex);
}
