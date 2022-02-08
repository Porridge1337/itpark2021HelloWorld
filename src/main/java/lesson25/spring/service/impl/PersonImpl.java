package lesson25.spring.service.impl;

import lesson25.spring.dao.PersonDAO;
import lesson25.spring.service.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonImpl implements Person {

    private PersonDAO dao;

    @Override
    public void print() {
        dao.save();
    }
}
