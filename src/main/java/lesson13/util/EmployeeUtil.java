package lesson13.util;

import lesson13.Employee;

import java.util.*;

public class EmployeeUtil {

    public static void printEmployee(Collection<Employee> employees, int workAge) {
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            if (employee.getWorkAge() > workAge) {
                System.out.println("Информация о сотруднике: id=" + employee.getId() + ", имя: " + employee.getName() +
                        ", фамилия: " + employee.getSurname() + ", опыт работы сотрудника равен=" + employee.getWorkAge() +
                        " лет");
            }
        }
    }

    public static void deleteEmployee(List<Employee> employees) {
        for (ListIterator<Employee> iterator = employees.listIterator(employees.size()); iterator.hasPrevious(); ) {
            Employee employee = iterator.previous();
            if (iterator.hasPrevious() && iterator.nextIndex() % 2 != 0) {
                iterator.remove();
            }
        }
    }
}
