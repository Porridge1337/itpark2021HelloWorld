package lesson15;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {

    public static void main(String[] args) {
        String sentences = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at\n" +
                "faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit\n" +
                "blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget\n" +
                "vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer\n" +
                "vel odio nec mi tempor dignissim";

        streamPrint(sentences);
    }

    public static void streamPrint(String sentences) {
        Map<String, Long> counts = Stream.of(sentences)
                .map(s -> s.split("(?U)\\W+"))
                .flatMap(strings -> Arrays.stream(strings))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        counts.entrySet().stream().forEach(i -> System.out.println(i));
    }

}
