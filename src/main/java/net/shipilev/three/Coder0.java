package net.shipilev.three;

public class Coder0 extends AbstractCoder implements Coder {
    @Override
    public int work(byte[] data) {
        return data.length;
    }

    public static int staticWork(byte[] data) {
        return data.length;
    }

    @Override
    public int abstractWork(byte[] data) {
        return data.length;
    }
}
