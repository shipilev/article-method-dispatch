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
public class Dispatch {

    @Param("10000")
    private int count;

    @Param({"0.0", "0.1", "0.5", "0.9", "1.0"})
    private double bias;

    private Target[] targets;

    @Setup
    public void setup() {
        Random r = new Random(12345);

        List<Target> ts = new ArrayList<Target>();
        for (int c = 0; c < count; c++) {
            byte[] contents = new byte[10];
            r.nextBytes(contents);

            byte id = (byte) (c < (bias * count) ? 1 : 0);
            ts.add(new Target(id, contents));
        }

        Collections.shuffle(ts, r);
        targets = ts.toArray(new Target[0]);
    }

    @Benchmark
    public void static_ID_switch() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_ID_switch();
        }
    }

    @Benchmark
    public void static_ID_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_ID_ifElse();
        }
    }

    @Benchmark
    public void static_Bool_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Bool_ifElse();
        }
    }

    @Benchmark
    public void static_Ref_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Ref_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_ID_switch() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_ID_switch();
        }
    }

    @Benchmark
    public void dynamic_Interface_ID_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_ID_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_ID_Array() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_ID_Array();
        }
    }

    @Benchmark
    public void dynamic_Interface_Bool_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Bool_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_Ref() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Ref();
        }
    }

    @Benchmark
    public void dynamic_Abstract_ID_switch() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_ID_switch();
        }
    }

    @Benchmark
    public void dynamic_Abstract_ID_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_ID_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Abstract_ID_Array() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_ID_Array();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Bool_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Bool_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Ref() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Ref();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Ref_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Ref_ifElse();
        }
    }

    @Benchmark
    public void dynamic_Interface_Ref_ifElse() {
        Target[] l = targets;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Ref_ifElse();
        }
    }

}
