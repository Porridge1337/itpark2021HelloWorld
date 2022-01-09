package lesson18;

public class FileThread implements Runnable {

    private static final String readLocation = "./src/main/resources/lesson18/fileRead/text.txt";

    @Override
    public void run() {
        new FileWriterAndReader().readFile(readLocation);
    }
}
