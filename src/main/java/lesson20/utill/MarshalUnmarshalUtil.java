package lesson20.utill;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lesson20.Employees;

import java.io.File;
import java.nio.file.Path;

public class MarshalUnmarshalUtil {

    public static void writeInXML(Employees employee, Path path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(employee, new File(path.toString()));
    }

    public static Employees readFromXML(Path path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Employees employees = (Employees) unmarshaller.unmarshal(new File(path.toString()));
        return employees == null ? null : employees;
    }
}
