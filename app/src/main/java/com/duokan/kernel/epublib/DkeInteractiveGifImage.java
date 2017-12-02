package com.duokan.kernel.epublib;

import com.duokan.kernel.DkAtomRenderOption;
import com.duokan.kernel.DkBox;

public class DkeInteractiveGifImage {
    private final long mDkeHandle;

    public native DkBox getBoundingBox();

    public native int getDuration(int i);

    public native int getFrameCount();

    public native int getHeight();

    public native String getMainTitle();

    public native String getSubTitle();

    public native int getWidth();

    public native void render(int i, DkAtomRenderOption dkAtomRenderOption);

    public DkeInteractiveGifImage(long j) {
        this.mDkeHandle = j;
    }
}
