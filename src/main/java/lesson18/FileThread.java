package lesson18;

import java.io.File;

public class FileThread implements Runnable {

    private static final String READ_LOCATION = "./src/main/resources/lesson18/fileRead/text.txt";

    @Override
    public void run() {
        new FileWriterAndReader().readFile(new File(READ_LOCATION));
    }
}
