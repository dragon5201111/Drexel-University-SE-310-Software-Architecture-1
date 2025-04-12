import java.io.Serializable;

public class A implements Serializable {
    private final char c;

    public A(char c) {
        this.c = c;
    }

    public char getC(){
        return this.c;
    }
}
