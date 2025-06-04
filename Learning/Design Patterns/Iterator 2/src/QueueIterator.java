
public class QueueIterator <T> implements Iterator<T> {
    private int index;
    private final Queue<T> queue;

    public QueueIterator(Queue<T> queue) {
        this.queue = queue;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.queue.size();
    }

    @Override
    public T next() {
        return this.queue.get(this.index++);
    }

    @Override
    public void reset() {
        this.index = 0;
    }
}
