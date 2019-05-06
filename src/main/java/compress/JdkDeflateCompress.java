package compress;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/**
 * JDK java.util.zip Deflater/Inflater 压缩方式
 *
 * @author zhangyupeng
 * @date 2019-05-05
 */
public class JdkDeflateCompress extends TestParent {

    @Param({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    int level;

    @Benchmark
    int deflate() throws IOException {
        return baseBenchmark(os -> new DeflaterOutputStream(os, new Deflater(level, true), InputGenerator.BUFFER_SIZE));
    }
}