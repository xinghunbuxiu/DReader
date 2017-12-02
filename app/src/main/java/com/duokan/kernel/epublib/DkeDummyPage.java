package com.duokan.kernel.epublib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;

public abstract class DkeDummyPage extends DkePage {
    private final DkFlowPosition mDkEndPos = new DkFlowPosition();
    private final DkFlowPosition mDkStartPos = new DkFlowPosition();

    public DkeDummyPage(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        super(0);
        this.mDkStartPos.mChapterIndex = dkFlowPosition.mChapterIndex;
        this.mDkStartPos.mParaIndex = dkFlowPosition.mParaIndex;
        this.mDkStartPos.mAtomIndex = dkFlowPosition.mAtomIndex;
        this.mDkEndPos.mChapterIndex = dkFlowPosition2.mChapterIndex;
        this.mDkEndPos.mParaIndex = dkFlowPosition2.mParaIndex;
        this.mDkEndPos.mAtomIndex = dkFlowPosition2.mAtomIndex;
    }

    public long render(DkFlowRenderOption dkFlowRenderOption) {
        return 0;
    }

    public long checkRenderStatus() {
        return 0;
    }

    public void setInvisible(int i) {
    }

    public void getBeginPosition(DkFlowPosition dkFlowPosition) {
        dkFlowPosition.mChapterIndex = this.mDkStartPos.mChapterIndex;
        dkFlowPosition.mParaIndex = this.mDkStartPos.mParaIndex;
        dkFlowPosition.mAtomIndex = this.mDkStartPos.mAtomIndex;
    }

    public void getEndPosition(DkFlowPosition dkFlowPosition) {
        dkFlowPosition.mChapterIndex = this.mDkEndPos.mChapterIndex;
        dkFlowPosition.mParaIndex = this.mDkEndPos.mParaIndex;
        dkFlowPosition.mAtomIndex = this.mDkEndPos.mAtomIndex;
    }

    public String getTextContent() {
        return "";
    }

    public String getTextContentOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        return "";
    }

    public DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        return new DkBox[0];
    }

    public DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2) {
        return new DkFlowPosition[0];
    }

    public DkeHitTestInfo hitTestObject(DkPos dkPos) {
        return null;
    }

    public DkFlowPosition[] hitTestTextRange(DkPos dkPos) {
        return new DkFlowPosition[0];
    }

    public DkFlowPosition[] hitTestTextRangeByMode(DkPos dkPos, int i) {
        return new DkFlowPosition[0];
    }

    public DkFlowPosition[] getCharPositions() {
        return new DkFlowPosition[0];
    }

    public CharSequence getChars() {
        return "";
    }

    public DkeLinkInfo hitTestLink(DkPos dkPos) {
        return null;
    }

    public DkeHitTestInfo[] getFootnotes() {
        return new DkeHitTestInfo[0];
    }

    public DkeHitTestInfo[] getInteractiveImages() {
        return new DkeHitTestInfo[0];
    }

    public DkeHitTestInfo[] getImages() {
        return new DkeHitTestInfo[0];
    }

    public DkeHitTestInfo[] getMedias() {
        return new DkeHitTestInfo[0];
    }

    public DkeGallery[] getGalleries() {
        return new DkeGallery[0];
    }

    public DkePreText[] getPreTexts() {
        return new DkePreText[0];
    }

    public DkeMultiCallout[] getMultiCallouts() {
        return new DkeMultiCallout[0];
    }

    public DkeInteractiveGifImage[] getInteractiveGifImages() {
        return new DkeInteractiveGifImage[0];
    }

    public DkeFormula[] getFormulas() {
        return new DkeFormula[0];
    }

    public DkeInteractiveTable[] getInteractiveTables() {
        return new DkeInteractiveTable[0];
    }

    public DkeInputInfo[] getInputs() {
        return new DkeInputInfo[0];
    }

    public DkeExercise[] getExercise() {
        return new DkeExercise[0];
    }

    public void buildPageElements() {
    }

    public boolean checkPageElements() {
        return false;
    }

    public long getFrameCount() {
        return 0;
    }

    public DkBox getFrameBoundary(long j) {
        return new DkBox();
    }

    public DkBox getFrameBoxOnPage(long j) {
        return new DkBox();
    }

    public long getGlobalFrameIndex(long j) {
        return -1;
    }

    public long getPageHeight() {
        return -1;
    }
}
