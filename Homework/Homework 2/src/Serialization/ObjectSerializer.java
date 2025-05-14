package Serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerializer{
    private static final String SER_DIRECTORY = System.getProperty("user.dir") + File.separator + "ser" + File.separator;
    private static final String SER_EXTENSION = ".ser";

    static {
        if(!ObjectSerializer.serializeDirectoryExists()){
            ObjectSerializer.createSerializeDirectory();
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

    private static String getSavePath(){
        return SER_DIRECTORY;
    }

    private static String getFilePath(String fileName) {
        return getSavePath() + fileName + SER_EXTENSION;
    }

    public static void serialize(Object object, String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getFilePath(fileName));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserialize(String fileName){
        try {
            FileInputStream fileInputStream = new FileInputStream(getFilePath(fileName));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object returnObject = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return returnObject;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String stripExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public static List<String> getSerializedFileNames(){
        File directory = new File(getSavePath());
        File[] files = directory.listFiles();

        List<String> serializedFiles = new ArrayList<>();
        if(files == null){
            return serializedFiles;
        }

        for(File file : files){
            String fileName = file.getName();

            if(fileName.contains("Response")){
                continue;
            }

            if(fileName.endsWith(SER_EXTENSION)){
                serializedFiles.add(stripExtension(fileName));
            }
        }

        return serializedFiles;
    }
}
