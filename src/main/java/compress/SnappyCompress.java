package compress;

import org.openjdk.jmh.annotations.Benchmark;
import org.xerial.snappy.SnappyFramedOutputStream;
import org.xerial.snappy.SnappyOutputStream;

import java.io.IOException;

/**
 * Snappy library 压缩方式
 *
 * @author zhangyupeng
 * @date 2019-05-05
 */
public class SnappyCompress extends TestParent {

    @Benchmark
    int snappyNormalOutput() throws IOException {
        return baseBenchmark(os -> new SnappyOutputStream(os, InputGenerator.BUFFER_SIZE));
    }

    @Benchmark
    int snappyFrameOutput() throws IOException {
        return baseBenchmark(SnappyFramedOutputStream::new);
    }
}