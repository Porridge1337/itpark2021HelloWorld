package lesson20.employeeFactory;

import lesson20.Employee;
import lesson20.enums.*;

import java.util.Random;

public class EmployeeFactory {

    public static Employee generateRandomEmployee() {
        CityEnums city = CityEnums.values()[new Random().nextInt(CityEnums.values().length - 1)];
        EmployeeNames names = EmployeeNames.values()[new Random().nextInt(EmployeeNames.values().length - 1)];
        EmployeeSurnames surnames = EmployeeSurnames.values()[new Random().nextInt(EmployeeSurnames.values().length - 1)];
        String fullName = names.toString() + " " + surnames.toString();
        PositionEnums position = PositionEnums.values()[new Random().nextInt(PositionEnums.values().length - 1)];
        SubdivisionEnums subdivision;
        switch (position) {
            case DEVELOPER -> subdivision = SubdivisionEnums.DEVELOPMENT_DEPARTMENT;
            case HR_MANAGER -> subdivision = SubdivisionEnums.HR_DEPARTMENT;
            case TESTER -> subdivision = SubdivisionEnums.TESTING_DEPARTMENT;
            default -> throw new IllegalStateException("Unexpected value: " + position);
        }
        return new Employee(String.valueOf(10000 + new Random().nextInt(10000)), names.toString(), fullName,
                subdivision.toString(), city.toString(), position.toString(),
                String.valueOf(500 + new Random().nextInt(500)));
    }
}
