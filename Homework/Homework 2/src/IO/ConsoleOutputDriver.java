package IO;

import java.util.List;

public class ConsoleOutputDriver extends OutputDriver {
    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public void printLines(List<String> lines) {
        this.printLines(lines, 0);
    }

    @Override
    public void printLines(List<String> lines, int startIndex) {
        for(; startIndex < lines.size(); startIndex++) {
            System.out.println(lines.get(startIndex));
        }
    }
}
