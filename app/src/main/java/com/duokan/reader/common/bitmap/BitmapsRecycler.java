package com.duokan.reader.common.bitmap;

public interface BitmapsRecycler {

    public enum RecycleReason {
        ApplicationExit,
        OutOfMemory,
        LowMemory
    }

    void a(RecycleReason recycleReason);
}
