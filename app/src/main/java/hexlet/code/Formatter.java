package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Formatter {
    static String getStylish(Map<String, Object> data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(data)
                .replaceAll("\"", "")
                .replaceAll(" :", ":");

    }

}
