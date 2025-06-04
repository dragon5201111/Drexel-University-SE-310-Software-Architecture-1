

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Iterator<Integer> queueIterator = queue.getIterator();

        queue.put(2);
        queue.put(3);
        queue.put(4);

        while (queueIterator.hasNext()) {
            System.out.println(queueIterator.next());
        }

        int _ = queue.pop();

        queueIterator.reset();
        while (queueIterator.hasNext()) {
            System.out.println(queueIterator.next());
        }
    }
}
