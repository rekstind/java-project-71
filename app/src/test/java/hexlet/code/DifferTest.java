package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void differJSON() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "stylish";

        String expected = Files.readString(Paths.get("src/test/resources/file1file2Compare.json"));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void differNestedJSON() throws Exception {
        String filepath1 = "src/test/resources/file3.json";
        String filepath2 = "src/test/resources/file4.json";
        String format = "stylish";

        String expected = Files.readString(Paths.get("src/test/resources/file3file4Compare.json"));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void differYML() throws Exception {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.yml";
        String format = "stylish";

        String expected = Files.readString(Paths.get("src/test/resources/file1file2Compare.json"));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void differNestedYML() throws Exception {
        String filepath1 = "src/test/resources/file3.yml";
        String filepath2 = "src/test/resources/file4.yml";
        String format = "stylish";

        String expected = Files.readString(Paths.get("src/test/resources/file3file4Compare.json"));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

}
