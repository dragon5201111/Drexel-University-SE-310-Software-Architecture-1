import java.util.ArrayList;
import java.util.List;

public class EditorHistory implements Observer {
    private final List<EditorMemento> mementos;

    public EditorHistory() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(EditorMemento memento) {
        this.mementos.add(memento);
    }

    public EditorMemento popMemento() {
        return this.mementos.removeLast();
    }

    public EditorMemento getLastMemento() {
        return this.mementos.getLast();
    }

    public EditorMemento getMemento(int index) {
        return this.mementos.get(index);
    }

    @Override
    public void update(Object object) {
        this.addMemento((EditorMemento) object);
    }
}
