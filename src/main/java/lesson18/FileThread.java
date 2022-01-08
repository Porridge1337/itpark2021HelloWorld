package lesson18;

public class FileThread implements Runnable {

    private FileWriterAndReader writeAndRead;
    private static final String readLocation = "./src/main/resources/lesson18/fileRead/text.txt";


    @Override
    public void run() {
        writeAndRead = new FileWriterAndReader();
        writeAndRead.readFile(readLocation);
    }
}
