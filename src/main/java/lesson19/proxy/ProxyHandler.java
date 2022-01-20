package lesson19.proxy;

import lesson19.BankOperations;
import lesson19.annotation.Blocked;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class ProxyHandler implements InvocationHandler {

    private final BankOperations origin;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method methodWithdraw = origin.getClass().getDeclaredMethod("withdraw", method.getParameterTypes());
        Method methodDeposit = origin.getClass().getDeclaredMethod("deposit", method.getParameterTypes());
        Blocked annotationWithdraw = methodWithdraw.getAnnotation(Blocked.class);
        Blocked annotationDeposit = methodDeposit.getAnnotation(Blocked.class);
        if (annotationWithdraw != null) {
            throw new Exception("Метод Withdraw - заблокирован");
        } else if (annotationDeposit != null) {
            throw new Exception("Метод Deposit - заблокирован");
        }
        Object result = methodWithdraw.invoke(origin, args);
        return result;
    }
}
