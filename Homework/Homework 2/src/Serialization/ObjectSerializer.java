package Serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerializer{
    private static final String SER_DIRECTORY = System.getProperty("user.dir") + File.separator + "ser" + File.separator;
    private static final String SER_EXTENSION = ".ser";

    static {
        if(!serializeDirectoryExists()){
            createSerializeDirectory();
        }
    }

    private static void createSerializeDirectory(){
        try{
            Files.createDirectory(Paths.get(SER_DIRECTORY));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean serializeDirectoryExists(){
        File directoryFile = new File(SER_DIRECTORY);
        return directoryFile.exists() && directoryFile.isDirectory();
    }

    private String getSavePath(){
        return SER_DIRECTORY;
    }

    private String getFilePath(String fileName) {
        return this.getSavePath() + fileName + SER_EXTENSION;
    }

    public void serialize(Object object, String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.getFilePath(fileName));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object deserialize(String fileName){
        try {
            FileInputStream fileInputStream = new FileInputStream(this.getFilePath(fileName));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object returnObject = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return returnObject;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String stripExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public List<String> getSerializedFileNames(){
        File directory = new File(this.getSavePath());
        File[] files = directory.listFiles();

        List<String> serializedFiles = new ArrayList<>();
        if(files == null){
            return serializedFiles;
        }

        for(File file : files){
            String fileName = file.getName();

            if(fileName.endsWith(SER_EXTENSION)){
                serializedFiles.add(this.stripExtension(fileName));
            }
        }

        return serializedFiles;
    }
}
