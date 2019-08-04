package decorator.wrong;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static decorator.common.FileIn.read;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by koseungbin on 2019-08-04
 */

@DisplayName("Decorator FileOut Test")
class FileOutTest {
    @Test
    void should_write_string_to_file() throws Exception {
        // given
        String file = "temp";
        FileOut fileOut = new FileOut(file);
        byte[] bytes = "Hello World".getBytes(StandardCharsets.UTF_8);

        // when
        fileOut.write(bytes, 0, bytes.length);

        // then
        assertEquals("Hello World", read(file), "같은 파일에 write, read 한 컨텐츠는 동일해야 한다.");

    }

    @Test
    void expect_exception_if_file_not_exist() {
        // given
        String file = "not_exist_file";

        // when then
        assertThrows(Exception.class, () -> new FileOut(file), "not_exist_file 파일은 존재하지 않으므로 예외가 발생해야 한다.");

    }

}