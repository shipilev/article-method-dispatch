package net.shipilev.three;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Three {

    @Param("10000")
    private int count;

    @Param("1")
    private int p1;

    @Param("1")
    private int p2;

    @Param("1")
    private int p3;

    private Data[] datas;

    @Setup
    public void setup() {
        Random r = new Random(12345);

        int s1 = (count * p1) / (p1 + p2 + p3);
        int s2 = (count * (p1 + p2)) / (p1 + p2 + p3);

        List<Data> ts = new ArrayList<Data>();
        for (int c = 0; c < count; c++) {
            byte[] contents = new byte[10];
            r.nextBytes(contents);

            byte id;
            if (c < s1) {
                id = 0;
            } else if (c < s2) {
                id = 1;
            } else {
                id = 2;
            }
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

    @Benchmark
    public void peel_Abstract_Abstract() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Peel_Abstract_Abstract();
        }
    }

    @Benchmark
    public void peel_Abstract_Static() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Peel_Abstract_Static();
        }
    }

    @Benchmark
    public void peel_Interface_Interface() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Peel_Interface_Interface();
        }
    }

    @Benchmark
    public void peel_Interface_Static() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Peel_Interface_Static();
        }
    }

}
