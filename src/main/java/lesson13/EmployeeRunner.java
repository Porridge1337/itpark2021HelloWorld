package lesson13;

import lesson13.dataEnum.Names;
import lesson13.dataEnum.Surnames;
import lesson13.util.EmployeeUtil;

import java.util.*;

public class EmployeeRunner {
    public static void main(String[] args) {
        List<Employee> employees = (List<Employee>) fillEmployeeList(new ArrayList<>());
        EmployeeUtil.printEmployee(employees, 2);
        EmployeeUtil.deleteEmployee(employees);
        System.out.println("-------------------------------------");
        EmployeeUtil.printEmployee(employees, 2);
        System.out.println("-------------------------------------");
        Set<Employee> employeeSet = (Set<Employee>) fillEmployeeList(new HashSet<>());
        EmployeeUtil.printEmployee(employeeSet, 1);
        System.out.println("-------------------------------------");

    }

    public static Collection<Employee> fillEmployeeList(Collection<Employee> arr) {
        if (!arr.isEmpty()) {
            return arr;
        }
        for (int i = 0; i < 50; i++) {
            arr.add(new Employee(new Random().nextInt(100),
                    Names.values()[new Random().nextInt(Names.values().length)].toString(),
                    Surnames.values()[new Random().nextInt(Names.values().length)].toString(),
                    Math.round(Math.random() * 40.0) / 10.0));
        }
        return arr;
    }

}
