package com.duokan.kernel;

public class DkStream extends DkNative {
    private final long mHandle;

    public native int available();

    public native Object clone();

    public native void close();

    public native long length();

    public native void mark(int i);

    public native boolean markSupported();

    public native int read();

    public native int read(byte[] bArr);

    public native int read(byte[] bArr, int i, int i2);

    public native void reset();

    public native long skip(long j);

    private DkStream(long j) {
        this.mHandle = j;
    }

    protected void finalize() {
        close();
    }
}
