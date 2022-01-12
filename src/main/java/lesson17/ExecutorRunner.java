package lesson17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorRunner {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Long> numbers = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            numbers.add((long) new Random().nextInt(1_000_000_000));
        }
        Collections.sort(numbers);

        Callable<Long> min = () -> {
            System.out.println("Минимальное значение = " + numbers.get(0));
            return numbers.get(0);
        };
        Callable<Long> average = () -> {
            long temp = 0;
            for (int i = 0; i < numbers.size(); i++) {
                temp += numbers.get(i);
            }
            temp = temp / numbers.size();
            System.out.println("Среднее значение = " + temp);
            return temp;
        };
        Callable<Long> max = () -> {
            System.out.println("Максимальное значение = " + numbers.get(numbers.size() - 1));
            return numbers.get(numbers.size() - 1);
        };

        List<Callable<Long>> threads = new ArrayList<>();
        threads.add(min);
        threads.add(average);
        threads.add(max);

        executorService.invokeAll(threads);
        executorService.shutdown();

    }
}
