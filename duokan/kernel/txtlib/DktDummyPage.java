package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;

class DktDummyPage extends DktPage {
    protected DktDummyPage(long j, long j2) {
        super(0);
        this.mByteOffset = j;
        this.mByteLength = j2;
    }

    public boolean isBeforeFirstPage() {
        return this.mByteOffset == Long.MIN_VALUE;
    }

    public boolean isAfterLastPage() {
        return this.mByteOffset == Long.MAX_VALUE;
    }

    protected long getDktHandle() {
        return super.getDktHandle();
    }

    public long render(DkFlowRenderOption dkFlowRenderOption) {
        return 0;
    }

    public long checkRenderStatus() {
        return 0;
    }

    public long getSizeInByte() {
        return 0;
    }

    public long getSizeInChar() {
        return 0;
    }

    public long getOffsetInByte() {
        return this.mByteOffset;
    }

    public long getOffsetInChar() {
        return 0;
    }

    public String getTextContent() {
        return "";
    }

    public String getTextContentOfRange(long j, long j2) {
        return "";
    }

    public DkBox[] getTextRects(long j, long j2) {
        return new DkBox[0];
    }

    public long[] getSelectionRange(DkPos dkPos, DkPos dkPos2) {
        return new long[0];
    }

    public long[] hitTestTextRange(DkPos dkPos) {
        return new long[0];
    }

    public long[] hitTestTextRangeByMode(DkPos dkPos, int i) {
        return new long[0];
    }

    public long[] getCharPositions() {
        return new long[0];
    }

    public CharSequence getChars() {
        return "";
    }

    public long getPageHeight() {
        return -1;
    }
}
