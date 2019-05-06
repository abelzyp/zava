package compress;

import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;

/**
 * Java LZ4 implementations 压缩方式
 *
 * @author zhangyupeng
 * @date 2019-05-05
 */
public class Lz4Compress extends TestParent {

    private final int BLOCK_64K = 64 * 1024;
    private final int BLOCK_128K = 128 * 1024;
    private final int MAX_BLOCK_SIZE = 32 * 1024 * 1024;

    @Benchmark
    int fastNative64K() throws IOException {
        return lz4(LZ4Factory.nativeInstance().fastCompressor(), BLOCK_64K);
    }

    @Benchmark
    int fastNative128K() throws IOException {
        return lz4(LZ4Factory.nativeInstance().fastCompressor(), BLOCK_128K);
    }

    @Benchmark
    int fastNative32M() throws IOException {
        return lz4(LZ4Factory.nativeInstance().fastCompressor(), MAX_BLOCK_SIZE);
    }

    //Uncomment these tests if you want to see the performance of the less efficient implementations.
    //Keep in mind that you will not get extra benefits from using those. The only 2 options which affect
    //the output size are fast/high compressor and a compressor buffer size.
    //In terms of performance, you will be affected more by a change of a slower compressor rather than
    //by increasing a compressor buffer.

    @Benchmark
    int highNative() throws IOException {
        return lz4(LZ4Factory.nativeInstance().highCompressor(), BLOCK_64K);
    }

//    @Benchmark
//    int fastUnsafe() throws IOException {
//        return lz4(LZ4Factory.unsafeInstance().fastCompressor(), BLOCK_64K);
//    }
//
//    @Benchmark
//    int highUnsafe() throws IOException {
//        return lz4(LZ4Factory.unsafeInstance().highCompressor(), BLOCK_64K);
//    }
//
//    @Benchmark
//    int fastSafe() throws IOException {
//        return lz4(LZ4Factory.safeInstance().fastCompressor(), BLOCK_64K);
//    }
//
//    @Benchmark
//    int highSafe() throws IOException {
//        return lz4(LZ4Factory.safeInstance().highCompressor(), BLOCK_64K);
//    }

    @Benchmark
    int fastNativeDouble64K() throws IOException {
        final LZ4Compressor compressor = LZ4Factory.nativeInstance().fastCompressor();
        return baseBenchmark(os -> new LZ4BlockOutputStream(new LZ4BlockOutputStream(os, BLOCK_64K, compressor), BLOCK_64K, compressor));
    }

    @Benchmark
    int fastNativeDouble32M() throws IOException {
        final LZ4Compressor compressor = LZ4Factory.nativeInstance().fastCompressor();
        return baseBenchmark(os -> new LZ4BlockOutputStream(new LZ4BlockOutputStream(os, MAX_BLOCK_SIZE, compressor), MAX_BLOCK_SIZE, compressor));
    }

    @Benchmark
    int fastNativeTriple32M() throws IOException {
        final LZ4Compressor compressor = LZ4Factory.nativeInstance().fastCompressor();
        return baseBenchmark(os -> new LZ4BlockOutputStream(new LZ4BlockOutputStream(new LZ4BlockOutputStream(os, MAX_BLOCK_SIZE, compressor), MAX_BLOCK_SIZE, compressor), MAX_BLOCK_SIZE, compressor));
    }

    private int lz4(final LZ4Compressor compressor, final int blockSize) throws IOException {
        return baseBenchmark(os -> new LZ4BlockOutputStream(os, blockSize, compressor));
    }
}