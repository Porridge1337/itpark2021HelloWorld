package lesson20.utill;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson20.Employees;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class JacsonUtil {

    public static void convertAndWrite(Employees employees, Path path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path.toString()), employees);
    }

    public static void printEmployeeByEventId(Path path) throws IOException {
        JsonNode node = new ObjectMapper().readValue(new File(path.toString()), JsonNode.class).
                get("employeeList");
        if (node.isArray()) {
            for (JsonNode jsonNode : node) {
                int jsonId = jsonNode.get("id").asInt();
                if (jsonId % 2 == 0) {
                    System.out.println(jsonNode);
                }
            }
        }
    }

}
