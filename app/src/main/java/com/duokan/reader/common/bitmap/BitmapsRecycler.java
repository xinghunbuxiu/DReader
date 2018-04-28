package com.duokan.reader.common.bitmap;

public interface BitmapsRecycler {

    public enum RecycleReason {
        ApplicationExit,
        OutOfMemory,
        LowMemory
    }

    /* renamed from: a */
    void mo1802a(RecycleReason recycleReason);
}
