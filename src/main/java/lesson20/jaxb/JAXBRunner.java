package lesson20.jaxb;

import lesson20.Employees;
import lesson20.employeeFactory.EmployeeFactory;
import lesson20.utill.MarshalUnmarshalUtil;
import lesson20.utill.XPathUtil;

import java.nio.file.Paths;

public class JAXBRunner {

    public static void main(String[] args) throws Exception {
        Employees employees = new Employees();
        for (int i = 0; i < 20; i++) {
            employees.getEmployeeList().add(EmployeeFactory.generateRandomEmployee());
        }

        MarshalUnmarshalUtil.writeInXML(employees, Paths.
                get("./src/main/resources/lesson20/jaxb/employee.xml"));

        System.out.println(MarshalUnmarshalUtil.readFromXML(Paths.
                get("./src/main/resources/lesson20/jaxb/employee.xml")));
        XPathUtil xpath = new XPathUtil();
        xpath.aboveAverageSalary(Paths.
                get("./src/main/resources/lesson20/jaxb/employee.xml"));
    }

}
