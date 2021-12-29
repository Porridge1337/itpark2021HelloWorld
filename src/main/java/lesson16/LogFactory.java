package lesson16;

import lesson16.enums.LogLevel;

import java.time.LocalDateTime;
import java.util.Random;

public class LogFactory {

    public LogInformation createRandomLog() {
        LogLevel logLevel = LogLevel.values()[new Random().nextInt(LogLevel.values().length - 1)];
        String message = "Статус лога в данный момент " + logLevel.toString();
        LocalDateTime date = LocalDateTime.now();
        return new LogInformation(message, date, logLevel);
    }

}
