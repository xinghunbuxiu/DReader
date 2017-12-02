package com.duokan.kernel.pdflib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

public class DkpPageEx extends DkNative {
    protected DkFlowPosition mDkStartPos = null;
    private final long mDkpHandle;
    protected DkpFlowParserOption mDkpParserOption = null;
    protected int mRefCount = 0;

    public native DkFlowPosition[] getCharPositions();

    public native CharSequence getChars();

    public native DkFlowPosition getPageEndPos();

    public native DkFlowPosition getPageStartPos();

    public native DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native String getTextContent();

    public native String getTextContentOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkFlowPosition[] hitTestTextRange(DkPos dkPos);

    protected native void renderPage(DkFlowRenderOption dkFlowRenderOption);

    protected DkpPageEx(long j) {
        this.mDkpHandle = j;
    }
}
