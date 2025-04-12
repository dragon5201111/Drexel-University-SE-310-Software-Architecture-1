import java.io.*;

public class Serializer<T extends Serializable> {

    public void serializeTo(T obj, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);
            oos.flush();

        } catch (IOException e) {
            throw new RuntimeException("Failed to write object to file", e);
        }
    }

    @SuppressWarnings("unchecked")
    public T deserializeFrom(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (T) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to read object from file", e);
        }
    }
}