package lesson11.exception;

public class ExcessiveDimensionsException extends RuntimeException{

    public ExcessiveDimensionsException(String message) {
        super(message);
    }
}
