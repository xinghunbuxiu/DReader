package com.duokan.kernel.epublib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;

public class DkeMultiCallout {
    private final long mDkeHandle;

    public native DkeHitTestInfo getBaseImageInfo();

    public native DkFlowPosition getBeginPosition();

    public native DkeFlexPage getCalloutCaption(int i);

    public native int getCalloutCount();

    public native DkeCalloutInfo getCalloutInfo(int i);

    public native DkeFlexPage getCalloutTitle(int i);

    public native DkFlowPosition getEndPosition();

    public native DkBox getNavigationBox();

    public native void recycle();

    public DkeMultiCallout(long j) {
        this.mDkeHandle = j;
    }
}
