package serialize;

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
import serialize.model.PoiGoodsPrice;
import serialize.model.SerializeModelBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 通过Java MicroBenchmark Harness微基准测试
 *
 * @author zhangyupeng
 * @date 2019-04-29
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2)
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class JmhDeserializationTest {

    private byte[] jdkSerialize;
    private String gsonSerialize;
    private String fastjsonSerialize;
    private String jacksonSerialize;
    private byte[] fstSerialize;
    private byte[] protostuffSerialize;

    @Setup
    public void setup() throws IOException {
        PoiGoodsPrice poiGoodsPrice = new SerializeModelBuilder().buildPoiGoodsPrice();
        jdkSerialize = JdkSerialize.serialize(poiGoodsPrice);
        gsonSerialize = GsonSerialize.serialize(poiGoodsPrice);
        fastjsonSerialize = FastjsonSerialize.serialize(poiGoodsPrice);
        jacksonSerialize = JacksonSerialize.serialize(poiGoodsPrice);
        fstSerialize = FstSerialize.serialize(poiGoodsPrice);
        protostuffSerialize = ProtostuffSerialize.serialize(poiGoodsPrice);
    }

    @Benchmark
    public Object jdkDeserialize() throws IOException, ClassNotFoundException {
        return JdkSerialize.deserialize(jdkSerialize);
    }

    @Benchmark
    public Object gsonDeserialize() {
        return GsonSerialize.deserialize(gsonSerialize, PoiGoodsPrice.class);
    }

    @Benchmark
    public Object fastjsonDeserialize() {
        return FastjsonSerialize.deserialize(fastjsonSerialize, PoiGoodsPrice.class);
    }

    @Benchmark
    public Object jacksonDeserialize() throws IOException {
        return JacksonSerialize.deserialize(jacksonSerialize, PoiGoodsPrice.class);
    }

    @Benchmark
    public Object fstDeserialize() {
        return FstSerialize.deserialize(fstSerialize);
    }

    @Benchmark
    public Object protostuffDeserialize() {
        return ProtostuffSerialize.deserialize(protostuffSerialize, PoiGoodsPrice.class);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhDeserializationTest.class.getSimpleName())
                .warmupIterations(2)
                .measurementIterations(5)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}