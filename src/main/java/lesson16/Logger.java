package lesson16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger extends Thread {

    private LogInformation logInformation;
    private LogFactory factory;
    private int sleepTime;
    private boolean isContinue = true;
    private final static String location = "./src/main/java/lesson16/ThreadLog.txt";

    public Logger(String threadIdentification, int sleepTime) {
        super(threadIdentification);
        this.sleepTime = sleepTime;
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
            while (isContinue) {
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

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }
}
