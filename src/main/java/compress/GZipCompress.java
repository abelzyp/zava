package compress;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * JDK GZIP 压缩方式
 *
 * @author zhangyupeng
 * @date 2019-05-05
 */
public class GZipCompress extends TestParent {

    @Benchmark
    int gzip() throws IOException {
        return baseBenchmark(os -> new GZIPOutputStream(os, InputGenerator.BUFFER_SIZE));
    }
}