package com.duokan.kernel.epublib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

public class DkeGallery extends DkNative {
    private final long mDkeHandle;
    private final long mDkePageHandle;

    public native DkFlowPosition getBeginPosition();

    public native DkBox getBoundary();

    public native int getCellCount();

    public native int getCurActiveCell();

    public native DkFlowPosition getEndPosition();

    public native DkBox getFirstTitleBoundary();

    public native DkBox getFirstTitleBoundaryInGallery();

    public native DkeHitTestInfo[] getFootnotes();

    public native DkBox getImageBoundary();

    public native DkBox getImageBoundaryInGallery();

    public native DkeHitTestInfo[] getInteractiveImages();

    public native DkBox getSecondTitleBoundary();

    public native DkBox getSecondTitleBoundaryInGallery();

    public native DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native int getTitleCount();

    public native DkeLinkInfo hitTestLink(DkPos dkPos);

    public native DkFlowPosition[] hitTestTextRange(DkPos dkPos);

    public native void recycle();

    public native void renderCellFirstTitle(int i, DkFlowRenderOption dkFlowRenderOption);

    public native void renderCellSecondTitle(int i, DkFlowRenderOption dkFlowRenderOption);

    public native void setCurActiveCell(int i);

    protected DkeGallery(long j, long j2) {
        this.mDkeHandle = j;
        this.mDkePageHandle = j2;
    }
}
