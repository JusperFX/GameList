package model.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath = "person.out";

    @Override
    public void save(Serializable serializable) {
        System.out.println("Saving data...");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            System.out.println("Data saved successfully."); // Для отладки
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    @Override
    public Object read() {
        System.out.println("Reading data...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject(); // Чтение объекта
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void clear() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}