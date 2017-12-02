package com.duokan.kernel.epublib;

import com.duokan.kernel.DkNative;

public class DKETocPointWrapper extends DkNative {
    private long mDKETocPoint;

    public native long GetChildByIndex(int i);

    public native long GetChildCount();

    public native int GetDepth();

    public native String GetDest();

    public native boolean GetDestPosition(DKFlowPosition dKFlowPosition);

    public native String GetTitle();

    public native boolean IsContentValid();

    public native String getDestPortionId();

    public DKETocPointWrapper(long j) {
        this.mDKETocPoint = j;
    }
}
