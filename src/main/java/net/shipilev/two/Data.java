package net.shipilev.two;

import org.openjdk.jmh.annotations.CompilerControl;

public class Data {

    private static final Coder0 coder0 = new Coder0();
    private static final Coder1 coder1 = new Coder1();

    private static final Coder[] coders = { coder0, coder1 };
    private static final AbstractCoder[] abstractCoders = { coder0, coder1 };

    private final boolean isCoder0;
    private final byte id;
    private final byte[] data;
    private final Coder coder;
    private final AbstractCoder abstractCoder;

    public Data(byte id, byte[] data) {
        this.id = id;
        this.data = data;
        this.isCoder0 = (id == 0);
        this.coder = interface_ID_Switch();
        this.abstractCoder = abstract_ID_Switch();
    }

    private Coder interface_ID_Switch() {
        switch (id) {
            case 0: return coder0;
            case 1: return coder1;
            default:
                throw new IllegalStateException();
        }
    }

    private Coder interface_Bool_IfElse() {
        return (isCoder0 ? coder0 : coder1);
    }

    private Coder interface_ID_IfElse() {
        if (id == 0) {
            return coder0;
        } else if (id == 1) {
            return coder1;
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
            default:
                throw new IllegalStateException();
        }
    }

    private AbstractCoder abstract_Bool_IfElse() {
        return (isCoder0 ? coder0 : coder1);
    }

    private AbstractCoder abstract_ID_IfElse() {
        if (id == 0) {
            return coder0;
        } else if (id == 1) {
            return coder1;
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
        } else {
            throw new IllegalStateException();
        }
    }


    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_Bool_ifElse() {
        if (isCoder0) {
            return Coder0.staticWork(data);
        } else {
            return Coder1.staticWork(data);
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Static_Interface_Ref_ifElse() {
        if (coder instanceof Coder0) {
            return Coder0.staticWork(data);
        } else if (coder instanceof Coder1) {
            return Coder1.staticWork(data);
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
        } else {
            throw new IllegalStateException();
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
    public int do_Dynamic_Interface_Bool_ifElse() {
        return interface_Bool_IfElse().work(data);
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
    public int do_Dynamic_Abstract_Bool_ifElse() {
        return abstract_Bool_IfElse().abstractWork(data);
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Abstract_Ref(){
        return abstractCoder.abstractWork(data);
    }

}
