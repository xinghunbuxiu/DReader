package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

public class DktPage extends DkNative {
    protected long mByteLength = -1;
    protected long mByteOffset = -1;
    protected final long mDktHandle;
    protected DktParserOption mDktParserOption = null;
    protected int mRefCount = 0;

    public native long checkRenderStatus();

    public native long[] getCharPositions();

    public native CharSequence getChars();

    public native long getOffsetInByte();

    public native long getOffsetInChar();

    public native long getPageHeight();

    public native long[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native long getSizeInByte();

    public native long getSizeInChar();

    public native String getTextContent();

    public native String getTextContentOfRange(long j, long j2);

    public native DkBox[] getTextRects(long j, long j2);

    public native long[] hitTestTextRange(DkPos dkPos);

    public native long[] hitTestTextRangeByMode(DkPos dkPos, int i);

    public native long render(DkFlowRenderOption dkFlowRenderOption);

    protected DktPage(long j) {
        this.mDktHandle = j;
        if (this.mDktHandle != 0) {
            this.mByteOffset = getOffsetInByte();
            this.mByteLength = getSizeInByte();
        }
    }

    protected long getDktHandle() {
        return this.mDktHandle;
    }

    public boolean isBeforeFirstPage() {
        return false;
    }

    public boolean isAfterLastPage() {
        return false;
    }
}
