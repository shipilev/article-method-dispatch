package net.shipilev.one;

import org.openjdk.jmh.annotations.CompilerControl;

public class Data {

    private static final Coder0 coder0 = new Coder0();

    private final boolean isCoder0;
    private final byte id;
    private final byte[] data;
    private final Coder coder;
    private final AbstractCoder abstractCoder;

    public Data(byte id, byte[] data) {
        this.id = id;
        this.data = data;
        this.isCoder0 = (id == 0);
        this.coder = coder0;
        this.abstractCoder = coder0;
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_Ref(){
        return Coder0.staticWork(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_Ref(){
        return coder.work(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_Ref(){
        return abstractCoder.abstractWork(data);
    }
}
