package com.duokan.kernel.pdflib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

public class DkpPage extends DkNative {
    private final long mBookHandle;
    private final long mPageNum;
    protected int mRefCount = 0;
    protected boolean mReleased = false;

    protected native DkpSearchResult[] findTextInPage(String str, int i);

    protected native void freePageContent();

    public native DkFlowPosition[] getCharPositions();

    public native CharSequence getChars();

    protected native float getHeight();

    protected native DkFlowPosition getPageEndPos();

    protected native DkFlowPosition getPageStartPos();

    public native DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native String getTextContentOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    protected native float getWidth();

    public native DkFlowPosition[] hitTestTextRange(DkPos dkPos);

    protected DkpPage(long j, long j2) {
        this.mBookHandle = j;
        this.mPageNum = j2;
    }
}
