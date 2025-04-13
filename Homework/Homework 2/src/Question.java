import java.io.Serializable;

public abstract class Question implements Serializable {
    protected String prompt;
    abstract public void displayQuestion();
    abstract public void takeQuestion();

    public void setPrompt(String prompt) {

    }
}
