package lesson18;


import java.io.*;

public class FileWriterAndReader {

    public void readFile(File readLocation) {
        try (BufferedReader br = new BufferedReader(new FileReader(readLocation))) {
            String text = "";
            int i = 0;
            while ((text = br.readLine()) != null) {
                writeFile(readLocation.getParent() + "/fileWrite/" + ++i + ".txt", text);
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
