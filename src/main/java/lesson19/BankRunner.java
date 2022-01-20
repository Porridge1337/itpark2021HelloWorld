package lesson19;

import lesson19.enun.BankType;
import lesson19.proxy.ProxyHandler;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.Arrays;

public class BankRunner {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        BankOperations legalBank = new BankAccount(new BigDecimal(1000), BankType.LEGAL_ENTITY);
        legalBank.withdraw(new BigDecimal(500));
        legalBank.deposit(new BigDecimal(2000));
        Class<BankAccount> aClass = BankAccount.class;
        Field[] declaredFields = aClass.getDeclaredFields();

        BankOperations operations = (BankOperations) Proxy.newProxyInstance(BankRunner.class.getClassLoader(),
                new Class[]{BankOperations.class},
                new ProxyHandler(legalBank));
        operations.withdraw(new BigDecimal(100));

        System.out.println(getPrivateMethod(aClass, legalBank));

        BankOperations secondLegalBank = createNewInstance(aClass.getConstructors(), new BigDecimal(2000), BankType.LEGAL_ENTITY);
        BankOperations thirdBank = createNewInstance(aClass.getConstructors(), new BigDecimal(0), BankType.INDIVIDUAL);
        System.out.println(secondLegalBank);

        System.out.println("до изменениея " + thirdBank);
        Field thirdBankField0 = declaredFields[0];
        Field thirdBankField1 = declaredFields[1];

        thirdBankField0.setAccessible(true);
        thirdBankField1.setAccessible(true);
        thirdBankField0.set(thirdBank, new BigDecimal(100));
        thirdBankField1.set(thirdBank, BankType.LEGAL_ENTITY);
        System.out.println("После изменения " + thirdBank);

        System.out.println(getPrivateMethod(aClass, thirdBank));


    }

    private static BankOperations createNewInstance(Constructor<?>[] constructors, BigDecimal amount, BankType type)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<BankOperations> legalEntityBankAccountConstructor = null;
        for (Constructor constructor : constructors) {
            if (constructor.getParameterTypes().length != 0) {
                legalEntityBankAccountConstructor = constructor;
                break;
            }
        }
        return legalEntityBankAccountConstructor.newInstance(amount, type);
    }

    private static String getPrivateMethod(Class<BankAccount> clazz, BankOperations account) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method method = clazz.getDeclaredMethod("getFundsAndBankType");
        method.setAccessible(true);
        return (String) method.invoke(account);
    }


}
