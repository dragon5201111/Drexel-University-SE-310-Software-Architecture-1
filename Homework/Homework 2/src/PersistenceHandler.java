import java.io.*;

public class PersistenceHandler {
    private String SER_DES_EXTENSION = ".ser";

    public void serialize(Object object, String fileName) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName + SER_DES_EXTENSION);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object deserialize(String fileName) throws Exception {
        fileName = fileName + SER_DES_EXTENSION;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object returnObject = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return returnObject;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
