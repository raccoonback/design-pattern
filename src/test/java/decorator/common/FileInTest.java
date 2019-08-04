package decorator.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by koseungbin on 2019-08-05
 */

@DisplayName("Decorator FileOut Test")
class FileInTest {
    @Test
    void should_read_content_from_file() throws Exception {
        // given
        File file = File.createTempFile("input_", ".html", new File(System.getProperty("user.dir")));
        FileWriter writer = new FileWriter(file);
        writer.write("Hello World");
        writer.close();

        // when
        String data = FileIn.read(file.getName());
        file.delete();

        // then
        assertEquals("Hello World", data, "같은 파일에 write, read 한 컨텐츠는 동일해야 한다.");

    }

    @Test
    void should_read_even_if_empty() throws Exception {
        // given
        File file = File.createTempFile("input_", ".html", new File(System.getProperty("user.dir")));

        // when
        String data = FileIn.read(file.getName());
        file.delete();

        // then
        assertEquals("", data, "Contents가 없는 파일일 경우, 빈 문자열을 반환해야 한다.");

    }

    @Test
    void expect_exception_if_file_not_exist() {
        // given
        String file = "not_exist_file";

        // when then
        assertThrows(FileNotFoundException.class, () -> FileIn.read(file), "not_exist_file 파일은 존재하지 않으므로 예외가 발생해야 한다.");

    }

}