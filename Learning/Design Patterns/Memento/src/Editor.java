import java.util.ArrayList;
import java.util.List;

public class Editor implements Subject{
    private final List<Observer> observers;
    private String content;

    public Editor() {
        this.observers = new ArrayList<>();
        this.content = "";
    }

    public void write(String text) {
        this.content += text;
        this.notifyObservers();
    }

    public void clear() {
        this.content = "";
        this.notifyObservers();
    }

    public String getContent() {
        return this.content;
    }

    public EditorMemento createMemento() {
        return new EditorMemento(this.content);
    }

    public void restoreMemento(EditorMemento memento) {
        this.content = memento.content();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.createMemento());
        }
    }
}
