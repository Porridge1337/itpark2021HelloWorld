package lesson25.spring.dao.impl;

import lesson25.spring.dao.PersonDAO;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public void save() {
        System.out.println("save was successful");
    }
}
