package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void differStylish() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "stylish";

        String expected = "{\n"
                + "  - follow: false,\n"
                + "    host: hexlet.io,\n"
                + "  - proxy: 123.234.53.22,\n"
                + "  - timeout: 50,\n"
                + "  + timeout: 20,\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void differDefault() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "stylish";

        String expected = "{\n"
                + "  - follow: false,\n"
                + "    host: hexlet.io,\n"
                + "  - proxy: 123.234.53.22,\n"
                + "  - timeout: 50,\n"
                + "  + timeout: 20,\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate(filepath1, filepath2, format);
        assertThat(actual).isEqualTo(expected);
    }

}
