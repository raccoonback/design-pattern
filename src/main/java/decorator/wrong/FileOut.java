package decorator.wrong;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @see java.io.FileOutputStream
 * @see java.lang.ProcessBuilder
 *
 * Created by koseungbin on 2019-08-04
 */

public class FileOut {
    private String dir;
    private String path;
    private ProcessBuilder processBuilder;
    private static final String PWD = "user.dir";
    private static final String ECHO = "echo";
    private static final int STABLE_EXIT = 0;
    private static final int MAX_TRY_COUNT = 3;

    public FileOut(String name) throws Exception {
        dir = System.getProperty(PWD);
        path = dir.concat("/").concat(name);
        initFile();
        processBuilder = setUpProcess();

    }

    private void initFile() throws Exception {
        if (!removeOrigin()) {
            throw new Exception("Failed to delete old file.");

        }

    }

    private boolean removeOrigin() {
        int tryCount = 0;
        File file = new File(path);
        while (tryCount++ < MAX_TRY_COUNT) {
            if (file.delete()) {
                break;

            }

        }

        return MAX_TRY_COUNT >= tryCount;

    }

    private ProcessBuilder setUpProcess() {
        ProcessBuilder fileAppendBuilder = new ProcessBuilder();
        return fileAppendBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(path)));

    }

    private byte[] subBytes(byte[] b, int off, int len) {
        byte[] sub = new byte[len];
        System.arraycopy(b, off, sub, 0, len);
        return sub;

    }

    public void write(byte[] b, int off, int len) throws Exception {
        byte[] data = subBytes(b, off, len);
        Process process = processBuilder
                .command(ECHO, new String(data, StandardCharsets.UTF_8))
                .start();
        if (process.waitFor() != STABLE_EXIT) {
            throw new Exception("Occurred while writing data.");

        }

        process.destroy();

    }

    public void close() { }

}