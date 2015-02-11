package net.shipilev.three;

import org.openjdk.jmh.annotations.CompilerControl;

public class Data {

    private static final Coder0 coder0 = new Coder0();
    private static final Coder1 coder1 = new Coder1();
    private static final Coder2 coder2 = new Coder2();
    private static final Coder[] coders = { coder0, coder1, coder2 };
    private static final AbstractCoder[] abstractCoders = { coder0, coder1, coder2 };

    private final byte id;
    private final byte[] data;
    private final Coder coder;
    private final AbstractCoder abstractCoder;

    public Data(byte id, byte[] data) {
        this.id = id;
        this.data = data;
        this.coder = interface_ID_Switch();
        this.abstractCoder = abstract_ID_Switch();
    }

    private Coder interface_ID_Switch() {
        switch (id) {
            case 0: return coder0;
            case 1: return coder1;
            case 2: return coder2;
            default:
                throw new IllegalStateException();
        }
    }

    private Coder interface_ID_IfElse() {
        if (id == 0) {
            return coder0;
        } else if (id == 1) {
            return coder1;
        } else if (id == 2) {
            return coder2;
        } else {
            throw new IllegalStateException();
        }
    }

    private Coder interface_ID_Array() {
        return coders[id];
    }

    private AbstractCoder abstract_ID_Switch() {
        switch (id) {
            case 0: return coder0;
            case 1: return coder1;
            case 2: return coder2;
            default:
                throw new IllegalStateException();
        }
    }

    private AbstractCoder abstract_ID_IfElse() {
        if (id == 0) {
            return coder0;
        } else if (id == 1) {
            return coder1;
        } else if (id == 2) {
            return coder2;
        } else {
            throw new IllegalStateException();
        }
    }

    private AbstractCoder abstract_ID_Array() {
        return abstractCoders[id];
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_ID_switch() {
        switch (id) {
            case 0: return Coder0.staticWork(data);
            case 1: return Coder1.staticWork(data);
            case 2: return Coder2.staticWork(data);
            default:
                throw new IllegalStateException();
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_ID_ifElse() {
        if (id == 0) {
            return Coder0.staticWork(data);
        } else if (id == 1) {
            return Coder1.staticWork(data);
        } else if (id == 2) {
            return Coder2.staticWork(data);
        } else {
            throw new IllegalStateException();
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_Abstract_Ref_ifElse() {
        if (abstractCoder instanceof Coder0) {
            return Coder0.staticWork(data);
        } else if (abstractCoder instanceof Coder1) {
            return Coder1.staticWork(data);
        } else if (abstractCoder instanceof Coder2) {
            return Coder2.staticWork(data);
        } else {
            throw new IllegalStateException();
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_Interface_Ref_ifElse() {
        if (coder instanceof Coder0) {
            return Coder0.staticWork(data);
        } else if (coder instanceof Coder1) {
            return Coder1.staticWork(data);
        } else if (coder instanceof Coder2) {
            return Coder2.staticWork(data);
        } else {
            throw new IllegalStateException();
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_Ref_ifElse() {
        if (coder instanceof Coder0) {
            return coder.work(data);
        } else if (coder instanceof Coder1) {
            return coder.work(data);
        } else if (coder instanceof Coder2) {
            return coder.work(data);
        } else {
            throw new IllegalStateException();
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_Ref_ifElse() {
        if (abstractCoder instanceof Coder0) {
            return abstractCoder.abstractWork(data);
        } else if (abstractCoder instanceof Coder1) {
            return abstractCoder.abstractWork(data);
        } else if (abstractCoder instanceof Coder2) {
            return abstractCoder.abstractWork(data);
        } else {
            throw new IllegalStateException();
        }
    }


    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Peel_Interface_Static() {
        if (coder instanceof Coder0) {
            return Coder0.staticWork(data);
        } else {
            return coder.work(data);
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Peel_Interface_Interface() {
        if (coder instanceof Coder0) {
            return coder.work(data);
        } else {
            return coder.work(data);
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Peel_Abstract_Static() {
        if (abstractCoder instanceof Coder0) {
            return Coder0.staticWork(data);
        } else {
            return abstractCoder.abstractWork(data);
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Peel_Abstract_Abstract() {
        if (abstractCoder instanceof Coder0) {
            return abstractCoder.abstractWork(data);
        } else {
            return abstractCoder.abstractWork(data);
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_ID_switch() {
        return interface_ID_Switch().work(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_ID_ifElse() {
        return interface_ID_IfElse().work(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_ID_Array() {
        return interface_ID_Array().work(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_Ref(){
        return coder.work(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_ID_switch() {
        return abstract_ID_Switch().abstractWork(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_ID_ifElse() {
        return abstract_ID_IfElse().abstractWork(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_ID_Array() {
        return abstract_ID_Array().abstractWork(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_Ref(){
        return abstractCoder.abstractWork(data);
    }

}
