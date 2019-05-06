package compress;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Create an input test file out of a local JDK docs directory (by concatenating all its files into one file)
 *
 * @author zhangyupeng
 * @date 2019-05-05
 */
class InputGenerator {

    static final int BUFFER_SIZE = 65536;
    private static final String JAVADOC_PATH = "gc.log.current";
    static final File FILE_PATH = new File("gc.log.current");

    static {
        if (!FILE_PATH.exists()) {
            try {
                makeJavadocFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void makeJavadocFile() throws IOException {
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(FILE_PATH), BUFFER_SIZE)) {
            appendDir(os, new File(JAVADOC_PATH));
        }
        System.out.println("Javadoc file created");
    }

    private static void appendDir(OutputStream os, File file) throws IOException {
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                appendDir(os, f);
            } else {
                Files.copy(f.toPath(), os);
            }
        }
    }
}