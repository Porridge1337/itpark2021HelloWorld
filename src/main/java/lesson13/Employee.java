package lesson13;

import java.util.Objects;
import java.util.Random;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private double workAge;

    public Employee() {
        this(new Random().nextInt(100), "anonymous", "anonymous", 0.0);
    }

    public Employee(int id, String name, String surname, double workAge) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workAge = workAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getWorkAge() {
        return workAge;
    }

    public void setWorkAge(double workAge) {
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workAge=" + workAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.workAge, workAge) == 0 && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, workAge);
    }
}
