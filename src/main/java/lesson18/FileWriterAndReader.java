package lesson18;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class FileWriterAndReader {

    public void readFile(String readLocation) {
        try (BufferedReader br = new BufferedReader(new FileReader(readLocation))) {
            String text = "";
            int i = 0;
            while ((text = br.readLine()) != null) {
                writeFile("./src/main/resources/lesson18/fileWrite/" + ++i + ".txt", text);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeFile(String writeLocation, String writeText) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeLocation))) {
            bw.write(writeText);
            System.out.println("запись произошла");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
