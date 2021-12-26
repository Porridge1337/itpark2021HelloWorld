package lesson16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogInformation {

    private final LogLevel logLevel;
    private String message;
    private LocalDateTime date;

    public LogInformation(String message, LocalDateTime date, LogLevel logLevel) {
        this.message = message;
        this.date = date;
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return this.date.format(formatter);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public String toString() {
        return "LogInformation{" +
                "message='" + message + '\'' +
                ", date=" + date +
                ", logLevel=" + logLevel +
                '}';
    }
}
