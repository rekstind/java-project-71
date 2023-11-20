package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String string1 = Files.readString(Paths.get(filepath1).toAbsolutePath().normalize());
        String string2 = Files.readString(Paths.get(filepath2).toAbsolutePath().normalize());

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(string1, HashMap.class);
        Map<String, Object> map2 = objectMapper.readValue(string2, HashMap.class);

        ArrayList<String> list = new ArrayList<>();
        list.addAll(map1.keySet());
        list.addAll(map2.keySet());

        Map<String, Object> result = new LinkedHashMap<>();
        list.stream()
                .sorted()
                .forEachOrdered(key -> getDiffOnKey(result, key, map1, map2));
        return "{\n " +result.toString().replaceAll("=", ": ").replaceAll(",", ",\n").substring(1).replaceAll("}", "\n}");

    }

    static void getDiffOnKey(Map<String, Object> result, String key, Map<String, Object> map1, Map<String, Object> map2) {
        if (!map1.containsKey(key)) {
            result.put(" + " + key, map2.get(key));
            return;
        }

        if (!map2.containsKey(key)) {
            result.put(" - " + key, map1.get(key));
            return;
        }

        if (map1.get(key).equals(map2.get(key))) {
            result.put("   " + key, map1.get(key));
        } else {
            result.put(" - " + key, map1.get(key));
            result.put(" + " + key, map2.get(key));
        }

    }
}
