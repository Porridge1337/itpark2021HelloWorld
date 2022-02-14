package lesson27.service.impl;

import lesson27.service.AnotherDAOService;

public class AnotherDAOServiceImpl implements AnotherDAOService {
    @Override
    public void print() {
        System.out.println("Вывод информации");
    }
}
