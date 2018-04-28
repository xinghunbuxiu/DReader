package com.duokan.reader.common.webservices.duokan;

import java.util.concurrent.CopyOnWriteArrayList;

public class DkCloudPurchasedFictionInfo extends DkCloudStoreBookInfo {
    public int mChapterCount;
    public boolean mEntire;
    public boolean mFinish;
    public String[][] mLabels;
    public String mLatest;
    public String mLatestId;
    public CopyOnWriteArrayList<String> mNotPurchasedChapterIds;
    public String[] mPaidChapterId;
    public CopyOnWriteArrayList<String> mPurchasedChapterIds;
    public String mTypeId;

    public DkCloudPurchasedFictionInfo() {
        this.mLatest = null;
        this.mLatestId = null;
        this.mChapterCount = 0;
        this.mFinish = false;
        this.mEntire = false;
        this.mPaidChapterId = new String[0];
        this.mLabels = (String[][]) null;
        this.mPurchasedChapterIds = new CopyOnWriteArrayList();
        this.mNotPurchasedChapterIds = new CopyOnWriteArrayList();
        this.mTypeId = "";
    }

    public DkCloudPurchasedFictionInfo(DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo) {
        super(dkCloudPurchasedFictionInfo);
        this.mLatest = null;
        this.mLatestId = null;
        this.mChapterCount = 0;
        this.mFinish = false;
        this.mEntire = false;
        this.mPaidChapterId = new String[0];
        this.mLabels = (String[][]) null;
        this.mPurchasedChapterIds = new CopyOnWriteArrayList();
        this.mNotPurchasedChapterIds = new CopyOnWriteArrayList();
        this.mTypeId = "";
        this.mLatest = dkCloudPurchasedFictionInfo.mLatest;
        this.mLatestId = dkCloudPurchasedFictionInfo.mLatestId;
        this.mChapterCount = dkCloudPurchasedFictionInfo.mChapterCount;
        this.mFinish = dkCloudPurchasedFictionInfo.mFinish;
        this.mEntire = dkCloudPurchasedFictionInfo.mEntire;
        this.mPaidChapterId = dkCloudPurchasedFictionInfo.mPaidChapterId;
        this.mLabels = dkCloudPurchasedFictionInfo.mLabels;
        this.mPurchasedChapterIds = new CopyOnWriteArrayList(dkCloudPurchasedFictionInfo.mPurchasedChapterIds);
        this.mNotPurchasedChapterIds = new CopyOnWriteArrayList(dkCloudPurchasedFictionInfo.mNotPurchasedChapterIds);
        this.mTypeId = dkCloudPurchasedFictionInfo.mTypeId;
    }
}
