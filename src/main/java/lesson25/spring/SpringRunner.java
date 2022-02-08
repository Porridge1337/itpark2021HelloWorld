package lesson25.spring;

import lesson25.spring.calculator.Calculator;
import lesson25.spring.service.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Calculator calculator = context.getBean(Calculator.class);
        System.out.println(calculator.sum(5, 8));
        System.out.println(calculator.multiply(5, 5));

        Person person = context.getBean(Person.class);
        person.print();
    }

}
