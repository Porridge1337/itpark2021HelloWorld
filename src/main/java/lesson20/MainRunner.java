package lesson20;

import lesson20.Employees;
import lesson20.employeeFactory.EmployeeFactory;
import lesson20.utill.JacsonUtil;
import lesson20.utill.MarshalUnmarshalUtil;
import lesson20.utill.XPathUtil;

import java.nio.file.Paths;

public class MainRunner {

    public static void main(String[] args) throws Exception {
        Employees employees = new Employees();
        for (int i = 0; i < 20; i++) {
            employees.getEmployeeList().add(EmployeeFactory.generateRandomEmployee());
        }
        MarshalUnmarshalUtil.writeInXML(employees, Paths.
                get("./src/main/resources/lesson20/jaxb/employee.xml"));
        Employees employeesFromXml = MarshalUnmarshalUtil.readFromXML(Paths.
                get("./src/main/resources/lesson20/jaxb/employee.xml"));
        JacsonUtil.convertAndWrite(employeesFromXml, Paths.get("./src/main/resources/lesson20/jaxb/employee.json"));
        JacsonUtil.printEmployeeByEventId(Paths.get("./src/main/resources/lesson20/jaxb/employee.json"));

        XPathUtil.aboveAverageSalary(Paths.
                get("./src/main/resources/lesson20/jaxb/employee.xml"));
    }

}
