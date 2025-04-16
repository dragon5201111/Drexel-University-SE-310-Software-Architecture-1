package IO;

import java.util.List;

public class ConsoleOutputDriver extends OutputDriver {
    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void printLines(List<String> lines) {

    }
}
