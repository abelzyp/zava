package compress;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * Just to set all annotations in one place
 *
 * @author zhangyupeng
 * @date 2019-05-05
 */
@BenchmarkMode(Mode.SingleShotTime)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class TestParent {
    private Path inputFile = InputGenerator.FILE_PATH.toPath();

    @Setup
    public void setup() {
        inputFile = InputGenerator.FILE_PATH.toPath();
    }

    interface StreamFactory {
        OutputStream getStream(final OutputStream os) throws IOException;
    }

    int baseBenchmark(final StreamFactory factory) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) inputFile.toFile().length());
        try (OutputStream os = factory.getStream(bos)) {
            Files.copy(inputFile, os);
        }
        return bos.size();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("GZIP:" + new GZipCompress().gzip());

        System.out.println("Snappy(normal):" + new SnappyCompress().snappyNormalOutput());
        System.out.println("Snappy(framed):" + new SnappyCompress().snappyFrameOutput());

        System.out.println("LZ4(fast 64K):" + new Lz4Compress().fastNative64K());
        System.out.println("LZ4(fast 128K):" + new Lz4Compress().fastNative128K());
        System.out.println("LZ4(fast 32M):" + new Lz4Compress().fastNative32M());
        System.out.println("LZ4(fast double 64K):" + new Lz4Compress().fastNativeDouble64K());
        System.out.println("LZ4(fast double 32M):" + new Lz4Compress().fastNativeDouble32M());
        System.out.println("LZ4(fast triple 32M):" + new Lz4Compress().fastNativeTriple32M());
        System.out.println("LZ4(high):" + new Lz4Compress().highNative());

        for (int i = 1; i <= 9; i++) {
            JdkDeflateCompress compress = new JdkDeflateCompress();
            compress.level = i;
            System.out.println("Deflate (level=" + i + "):" + compress.deflate());
        }
    }
}