import java.util.ArrayList;
import java.util.List;

public class Queue <T> implements Iterable<T>{
    private final List<T> elements;

    public Queue() {
        this.elements = new ArrayList<>();
    }

    public void put(T element) {
        this.elements.add(element);
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    public T pop(){
        return this.elements.removeFirst();
    }

    public int size() {
        return this.elements.size();
    }

    @Override
    public Iterator<T> getIterator() {
        return new QueueIterator<>(this);
    }
}
