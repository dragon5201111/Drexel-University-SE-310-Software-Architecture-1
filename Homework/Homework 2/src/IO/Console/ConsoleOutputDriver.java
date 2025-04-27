package IO.Console;
import java.io.Serializable;
import java.util.List;

public class ConsoleOutputDriver implements Serializable {
    private final static long serialVersionUID = 2L;

    public void println(String s) {
        System.out.println(s);
    }

    public void println(){
        System.out.println();
    }

    public void print(String s) {
        if(s.isEmpty()){
            return;
        }
        System.out.print(s);
    }

    public void printLines(List<String> lines) {
        this.printLines(lines, 0);
    }

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
