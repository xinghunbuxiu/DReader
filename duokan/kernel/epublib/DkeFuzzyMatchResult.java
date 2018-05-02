package com.duokan.kernel.epublib;

import com.duokan.kernel.DkFlowPosition;

public class DkeFuzzyMatchResult {
    public long mEndOffset = 0;
    public DkFlowPosition mEndPos = null;
    public long mStartOffset = 0;
    public DkFlowPosition mStartPos = null;

    public boolean isEmpty() {
        if (this.mStartPos == null || this.mEndPos == null || this.mStartPos.equals(this.mEndPos) || this.mStartOffset == this.mEndOffset) {
            return true;
        }
        return false;
    }
}
