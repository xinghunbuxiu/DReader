package com.duokan.kernel.epublib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;

public class DkeComicsFrame extends DkNative {
    private final long mDkeHandle;

    public native long getChapterIndexOfFrame();

    public native DkBox getComicsImageBoundary();

    public native String getComicsImagePath();

    public native DkBox getFrameBoundaryOnImage();

    public native long getFrameIndexInThread();

    public native void renderFrame(DkFlowRenderOption dkFlowRenderOption);

    protected DkeComicsFrame(long j) {
        this.mDkeHandle = j;
    }
}
