package lesson16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Logger extends Thread {

    private LogInformation logInformation;
    private LogFactory factory;
    private int sleepTime;
    private AtomicBoolean flag;
    private final static String location = "./src/main/resources/lesson16/ThreadLog.txt";

    public Logger(String threadIdentification, AtomicBoolean flag, int sleepTime) {
        super(threadIdentification);
        this.sleepTime = sleepTime;
        this.flag=flag;
        createLog();
    }

    private void createLog() {
        factory = new LogFactory();
        logInformation = factory.createRandomLog();
    }

    private void writeToFile(String logText) throws IOException {
        FileWriter fileWriter = new FileWriter(location, true);
        fileWriter.write(logText);
        fileWriter.append('\n');
        fileWriter.flush();
        fileWriter.close();
    }

    public static void readLogFile() throws IOException {
        FileReader reader = new FileReader(location);
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    @Override
    public void run() {
        try {
            while (!flag.get()) {
                String log = "Текущее время и дата: " + logInformation.getDate() + ", " +
                        "Log level: " + logInformation.getLogLevel() + ", " +
                        "Идентификатор треда: " + getName() + ", " +
                        logInformation.getMessage();
                writeToFile(log);
                Thread.sleep(1000 * sleepTime);
                logInformation.setDate(LocalDateTime.now());
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
