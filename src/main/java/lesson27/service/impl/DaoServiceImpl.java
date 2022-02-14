package lesson27.service.impl;

import lesson27.service.AnotherDAOService;
import lesson27.service.DAOService;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoServiceImpl implements DAOService {

    private AnotherDAOService service;

    @Autowired
    public DaoServiceImpl(AnotherDAOService service) {
        this.service = service;
    }

    @Override
    public void save() {
        System.out.println("Сохранение успешно прошло");
        service.print();
    }
}
