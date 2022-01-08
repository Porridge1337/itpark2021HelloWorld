package lesson18;

public class FileRunner {
    public static void main(String[] args) {
        new Thread(new FileThread()).start();
    }
}
