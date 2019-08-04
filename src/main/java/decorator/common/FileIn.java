package decorator.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by koseungbin on 2019-08-04
 */

public final class FileIn {
    public static String read(String file) throws IOException {
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir").concat("/").concat(file));
        int len = inputStream.available();
        int acc = 0;
        int count;
        byte[] bytes = new byte[len];
        while ((len > 0) && (count = inputStream.read(bytes, acc, len)) >= 0) {
            acc += count;
            len -= acc;

        }

        inputStream.close();
        return new String(bytes, StandardCharsets.UTF_8).trim();

    }

}