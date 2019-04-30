package serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 通过Java MicroBenchmark Harness微基准测试
 *
 * @author zhangyupeng
 * @date 2019-04-29
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SerializationJmhTest {

    private PoiGoodsPrice poiGoodsPrice;

    @Setup
    public void setup() {
        poiGoodsPrice = new SerializeModelBuilder().buildPoiGoodsPrice();
    }

    @Benchmark
    public byte[] jdkSerialize() throws IOException {
        return JdkSerialize.serialize(poiGoodsPrice);
    }

    @Benchmark
    public String gsonSerialize() {
        return GsonSerialize.serialize(poiGoodsPrice);
    }

    @Benchmark
    public String fastjsonSerialize() {
        return FastjsonSerialize.serialize(poiGoodsPrice);
    }

    @Benchmark
    public String jacksonSerialize() throws JsonProcessingException {
        return JacksonSerialize.serialize(poiGoodsPrice);
    }

    @Benchmark
    public byte[] fstSerialize() {
        return FstSerialize.serialize(poiGoodsPrice);
    }

    @Benchmark
    public byte[] protostuffSerialize() {
        return ProtostuffSerialize.serialize(poiGoodsPrice);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SerializationJmhTest.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .forks(1)
                .jvmArgs("-server", "-Xms2048m", "-Xmx2048m")
//                .addProfiler(GCProfiler.class)
//                .addProfiler(StackProfiler.class)
                .build();
        new Runner(opt).run();
    }
}