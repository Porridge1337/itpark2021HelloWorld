package tst;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSetTest {

    public static void main(String[] args) {
        Set<Product> check = new TreeSet<Product>();
        check.add(new Product(66, "Хлеб", "23"));
        check.add(new Product(7, "лук", "15"));
        check.add(new Product(3, "морковь", "66"));
        check.add(new Product(23, "молоко", "58"));
        check.add(new Product(2, "сок", "100"));
        check.add(new Product(-6, "швепс", "49"));
        check.add(new Product(-1, "торт", "228"));
        System.out.println(check.toString());
    }
}
