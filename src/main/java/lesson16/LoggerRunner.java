package lesson16;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerRunner {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Начало работы потоков");
        Logger log1 = new Logger("LogThread-1", 3); //sleepTime указывать в секундах
        log1.start();
        Logger log2 = new Logger("LogThread-2", 2);
        log2.start();
        Logger log3 = new Logger("LogThread-3", 4);
        log3.start();
        Thread.sleep(60 * 1000);
        log1.setContinue(false);
        log2.setContinue(false);
        log3.setContinue(false);
        Logger.readLogFile();
        System.out.println("Вывод логов и окончание работы потоков");

    }

}
