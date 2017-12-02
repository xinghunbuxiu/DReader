package com.duokan.kernel.epublib;

import com.duokan.kernel.DkFlowPosition;

public class DkeErrorPage extends DkeDummyPage {
    private final long mDkError;

    public DkeErrorPage(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2, long j) {
        super(dkFlowPosition, dkFlowPosition2);
        this.mDkError = j;
    }

    public long getErrorCode() {
        return this.mDkError;
    }
}
