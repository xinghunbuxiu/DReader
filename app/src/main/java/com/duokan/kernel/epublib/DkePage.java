package com.duokan.kernel.epublib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

public class DkePage extends DkNative {
    protected final long mDkeHandle;

    public native void buildPageElements();

    public native boolean checkPageElements();

    public native long checkRenderStatus();

    public native void getBeginPosition(DkFlowPosition dkFlowPosition);

    public native DkFlowPosition[] getCharPositions();

    public native CharSequence getChars();

    public native void getEndPosition(DkFlowPosition dkFlowPosition);

    public native DkeExercise[] getExercise();

    public native DkeHitTestInfo[] getFootnotes();

    public native DkeFormula[] getFormulas();

    public native DkBox getFrameBoundary(long j);

    public native DkBox getFrameBoxOnPage(long j);

    public native long getFrameCount();

    public native DkeGallery[] getGalleries();

    public native long getGlobalFrameIndex(long j);

    public native DkeHitTestInfo[] getImages();

    public native DkeInputInfo[] getInputs();

    public native DkeInteractiveGifImage[] getInteractiveGifImages();

    public native DkeHitTestInfo[] getInteractiveImages();

    public native DkeInteractiveTable[] getInteractiveTables();

    public native DkeHitTestInfo[] getMedias();

    public native DkeMultiCallout[] getMultiCallouts();

    public native long getPageHeight();

    public native DkePreText[] getPreTexts();

    public native DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native String getTextContent();

    public native String getTextContentOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkeLinkInfo hitTestLink(DkPos dkPos);

    public native DkeHitTestInfo hitTestObject(DkPos dkPos);

    public native DkFlowPosition[] hitTestTextRange(DkPos dkPos);

    public native DkFlowPosition[] hitTestTextRangeByMode(DkPos dkPos, int i);

    public native long render(DkFlowRenderOption dkFlowRenderOption);

    public native void setInvisible(int i);

    public DkePage(long j) {
        this.mDkeHandle = j;
    }
}
