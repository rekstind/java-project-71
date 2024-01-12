package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String string1 = Files.readString(getNormalizePath(filepath1));
        String string2 = Files.readString(getNormalizePath(filepath2));

        Map<String, Object> map1 = Parser.parse(string1, getDataExtention(filepath1));
        Map<String, Object> map2 = Parser.parse(string2, getDataExtention(filepath2));

        ArrayList<String> list = new ArrayList<>();
        list.addAll(map1.keySet());
        list.addAll(map2.keySet());

        Map<String, Object> result = new LinkedHashMap<>();
        list.stream()
                .sorted()
                .forEachOrdered(key -> getDiffOnKey(result, key, map1, map2));

        switch (format) {
            default:
                return Formatter.getStylish(result);
        }
    }

    static Path getNormalizePath(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    static String getDataExtention(String filepath) {
        return filepath.split("\\.")[1];
    }

    static void getDiffOnKey(Map<String, Object> result, String key, Map<String, Object> map1,
                             Map<String, Object> map2) {
        if (!map1.containsKey(key)) {
            result.put("+ " + key, getStingValue(map2.get(key)));
            return;
        }

        if (!map2.containsKey(key)) {
            result.put("- " + key, getStingValue(map1.get(key)));
            return;
        }

        var value1 = getStingValue(map1.get(key));
        var value2 = getStingValue(map2.get(key));

        if (isEqual(value1, value2)) {
            result.put("  " + key, value1);
        } else {
            result.put("- " + key, value1);
            result.put("+ " + key, value2);
        }
    }

    static String getStingValue(Object o) {
        if (o == null) {
            return null;
        }

        return o.toString();
    }
    static boolean isEqual(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }

        return value1.equals(value2);
    }
}
