package com.duokan.kernel;

public class DkFlowPosition {
    public long mAtomIndex;
    public long mChapterIndex;
    public long mParaIndex;

    public DkFlowPosition() {
        this.mChapterIndex = -1;
        this.mParaIndex = -1;
        this.mAtomIndex = -1;
        this.mChapterIndex = 0;
        this.mParaIndex = 0;
        this.mAtomIndex = 0;
    }

    public DkFlowPosition(DkFlowPosition dkFlowPosition) {
        this.mChapterIndex = -1;
        this.mParaIndex = -1;
        this.mAtomIndex = -1;
        this.mChapterIndex = dkFlowPosition.mChapterIndex;
        this.mParaIndex = dkFlowPosition.mParaIndex;
        this.mAtomIndex = dkFlowPosition.mAtomIndex;
    }

    public DkFlowPosition(long j, long j2, long j3) {
        this.mChapterIndex = -1;
        this.mParaIndex = -1;
        this.mAtomIndex = -1;
        this.mChapterIndex = j;
        this.mParaIndex = j2;
        this.mAtomIndex = j3;
    }

    public boolean equals(Object obj) {
        DkFlowPosition dkFlowPosition = (DkFlowPosition) obj;
        return this.mChapterIndex == dkFlowPosition.mChapterIndex && this.mParaIndex == dkFlowPosition.mParaIndex && this.mAtomIndex == dkFlowPosition.mAtomIndex;
    }
}
