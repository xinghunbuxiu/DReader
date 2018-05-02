package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.DkStoreFictionChapterInfo;

import java.util.Date;

public class DkCloudFictionChapter extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudFictionChapter.class.desiredAssertionStatus());
    private final DkStoreFictionChapterInfo mChapterInfo;
    private ChapterState mChapterState = ChapterState.NORMAL;
    private final boolean mIsFree;

    public enum ChapterState {
        NORMAL,
        FREE,
        ORDER
    }

    public DkCloudFictionChapter(DkStoreFictionChapterInfo dkStoreFictionChapterInfo, boolean z) {
        super(0);
        this.mChapterInfo = dkStoreFictionChapterInfo;
        boolean z2 = z || this.mChapterInfo.mPrice == 0;
        this.mIsFree = z2;
        if (this.mIsFree) {
            this.mChapterState = ChapterState.FREE;
        }
    }

    public String getCloudId() {
        return this.mChapterInfo.mChapterId;
    }

    public String getTitle() {
        return this.mChapterInfo.mTitle;
    }

    public String getUrl() {
        return this.mChapterInfo.mUrl;
    }

    public String getSha1() {
        return this.mChapterInfo.mSha1;
    }

    public boolean isFree() {
        return this.mIsFree;
    }

    public Date getUpdateDate() {
        return this.mChapterInfo.mUpdatedDate;
    }

    public int getPrice() {
        return this.mIsFree ? 0 : this.mChapterInfo.mPrice;
    }

    public int getBasePrice() {
        return this.mChapterInfo.mBasePrice;
    }

    public long getWordCount() {
        return this.mChapterInfo.mWordCount;
    }

    public void setChapterState(ChapterState chapterState) {
        this.mChapterState = chapterState;
    }

    public boolean getVisible() {
        return this.mChapterInfo.mVisible;
    }

    public ChapterState getChapterState() {
        return this.mChapterState;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }
}
