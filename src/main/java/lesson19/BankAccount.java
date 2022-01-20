package lesson19;

import lesson19.annotation.Blocked;
import lesson19.enun.BankType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class BankAccount implements BankOperations {

    private BigDecimal funds;
    private final BankType type;

    public BankAccount() {
        this(null, BankType.INDIVIDUAL);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amount) {
        if (funds.compareTo(amount) == -1) {
            throw new IllegalArgumentException("Невозможно вывести сумму больше суммы баланса");
        }
        funds = funds.subtract(amount);
        return funds;
    }

    @Override
    @Blocked()
    public BigDecimal deposit(BigDecimal amount) {
        funds = funds.add(amount);
        return funds;
    }

    private String getFundsAndBankType() {
        return "Баланс равен: " + funds + ". Тип счёта - " + type;
    }
}
