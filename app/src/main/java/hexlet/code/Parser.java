package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String data, String dataExtention) throws JsonProcessingException {
        ObjectMapper objectMapper;
        if (dataExtention.equals("yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            objectMapper = new ObjectMapper();
        }

        return objectMapper.readValue(data, HashMap.class);
    }
}
