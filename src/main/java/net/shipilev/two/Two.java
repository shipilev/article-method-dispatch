package net.shipilev.two;

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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Two {

    @Param("10000")
    private int count;

    @Param({"0.0", "0.1", "0.5", "0.9", "1.0"})
    private double bias;

    private Data[] datas;

    @Setup
    public void setup() {
        Random r = new Random(12345);

        List<Data> ts = new ArrayList<Data>();
        for (int c = 0; c < count; c++) {
            byte[] contents = new byte[10];
            r.nextBytes(contents);

            byte id = (byte) (c < (bias * count) ? 1 : 0);
            ts.add(new Data(id, contents));
        }

        Collections.shuffle(ts, r);
        datas = ts.toArray(new Data[0]);
    }

    @Benchmark
    public void static_ID_switch() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_ID_switch();
        }
    }

    @Benchmark
    public void static_ID_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_ID_ifElse();
        }
    }

    @Benchmark
    public void static_Bool_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Bool_ifElse();
        }
    }

    @Benchmark
    public void static_Abstract_Ref_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Abstract_Ref_ifElse();
        }
    }

    @Benchmark
    public void static_Interface_Ref_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Interface_Ref_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_ID_switch() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_ID_switch();
        }
    }

    @Benchmark
    public void dynamic_Interface_ID_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_ID_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_ID_Array() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_ID_Array();
        }
    }

    @Benchmark
    public void dynamic_Interface_Bool_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Bool_ifElse();
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
    public void dynamic_Abstract_ID_switch() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_ID_switch();
        }
    }

    @Benchmark
    public void dynamic_Abstract_ID_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_ID_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Abstract_ID_Array() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_ID_Array();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Bool_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Bool_ifElse();
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

    @Benchmark
    public void dynamic_Abstract_Ref_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Ref_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_Ref_ifElse() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Ref_ifElse();
        }
    }

}
