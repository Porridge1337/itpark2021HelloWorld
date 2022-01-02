package lesson16;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoggerRunner {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Начало работы потоков.");
        AtomicBoolean flag1 = new AtomicBoolean(false);
        AtomicBoolean flag2 = new AtomicBoolean(false);
        AtomicBoolean flag3 = new AtomicBoolean(false);
        Logger log1 = new Logger("LogThread-1", flag1, 3); //sleepTime указывать в секундах
        Logger log2 = new Logger("LogThread-2", flag2, 2);
        Logger log3 = new Logger("LogThread-3", flag3, 4);
        log1.start();
        log2.start();
        log3.start();
        Thread.sleep(60 * 1000);
        flag1.set(true);
        flag2.set(true);
        flag3.set(true);
        Logger.readLogFile();
        System.out.println("Вывод логов и окончание работы потоков");

    }

}
