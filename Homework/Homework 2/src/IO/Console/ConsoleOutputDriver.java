package IO.Console;

import IO.OutputDriver;

import java.io.Serializable;
import java.util.List;

public class ConsoleOutputDriver extends OutputDriver implements Serializable {
    private final static long serialVersionUID = 2L;

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    public void println(){
        System.out.println();
    }

    @Override
    public void print(String s) {
        if(s.isEmpty()){
            return;
        }
        System.out.print(s);
    }

    @Override
    public void printLines(List<String> lines) {
        this.printLines(lines, 0);
    }

    @Override
    public void printLines(List<String> lines, int startIndex) {
        if(lines.isEmpty() || startIndex >= lines.size() || startIndex < 0){
            return;
        }

        for(; startIndex < lines.size(); startIndex++) {
            System.out.println(lines.get(startIndex));
        }
    }

    public void printNumberedLines(List<String> lines, int maxLines) {
        if(lines.isEmpty()){
            return;
        }

        for(int i = 0; i < lines.size() && i < maxLines; i++){
            System.out.println((i+1) + ") " + lines.get(i));
        }
    }
}
