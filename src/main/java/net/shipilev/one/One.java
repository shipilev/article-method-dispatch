package net.shipilev.one;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class One {

    @Param("10000")
    private int count;

    private Data[] datas;

    @Setup
    public void setup() {
        Random r = new Random();

        datas = new Data[count];
        for (int c = 0; c < count; c++) {
            byte[] contents = new byte[10];
            r.nextBytes(contents);

            datas[c] = new Data((byte) 0, contents);
        }
    }

    @Benchmark
    public void static_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Ref();
        }
    }

    @Benchmark
    public void dynamic_Interface_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Ref();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Ref();
        }
    }



}
