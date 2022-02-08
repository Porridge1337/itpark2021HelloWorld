package lesson25.spring.calculator.impl;

import lesson25.spring.calculator.Calculator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorImpl implements Calculator {

    private int a;
    private int b;

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
