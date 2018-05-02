package com.duokan.kernel;

public abstract class DkNative {
    private static native void load();

    static {
        System.loadLibrary("dkkernel");
        load();
    }
}
