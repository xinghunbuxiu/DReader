package com.duokan.kernel.pdflib;

import com.duokan.kernel.DkFlowPosition;

public class DkpSearchResult {
    public final int mEndPosInSnippet;
    public final DkFlowPosition mMatchEndPos;
    public final DkFlowPosition mMatchStartPos;
    public final String mSnippetText;
    public final int mStartPosInSnippet;

    protected DkpSearchResult(String str, int i, int i2, DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        this.mSnippetText = str;
        this.mStartPosInSnippet = i;
        this.mEndPosInSnippet = i2;
        this.mMatchStartPos = dkFlowPosition;
        this.mMatchEndPos = dkFlowPosition2;
    }
}
