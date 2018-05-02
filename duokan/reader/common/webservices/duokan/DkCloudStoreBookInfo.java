package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;

public class DkCloudStoreBookInfo implements Serializable {
    public String[] mAuthors = null;
    public String mBookUuid = null;
    public String mCoverUri = null;
    public String[] mEditors = null;
    public boolean mIsHide = false;
    public String mOrderUuid = null;
    private long mPurchaseTime;
    public String mTitle = null;
    public long mUpdateTime;

    public DkCloudStoreBookInfo(DkCloudStoreBookInfo dkCloudStoreBookInfo) {
        this.mOrderUuid = dkCloudStoreBookInfo.mOrderUuid;
        this.mBookUuid = dkCloudStoreBookInfo.mBookUuid;
        this.mTitle = dkCloudStoreBookInfo.mTitle;
        this.mCoverUri = dkCloudStoreBookInfo.mCoverUri;
        this.mAuthors = dkCloudStoreBookInfo.mAuthors;
        this.mEditors = dkCloudStoreBookInfo.mEditors;
        this.mPurchaseTime = dkCloudStoreBookInfo.mPurchaseTime;
        this.mUpdateTime = dkCloudStoreBookInfo.mUpdateTime;
        this.mIsHide = dkCloudStoreBookInfo.mIsHide;
    }

    public void setPurchaseTimeInSeconds(long j) {
        this.mPurchaseTime = j;
    }

    public long getPurchaseTimeInSeconds() {
        return this.mPurchaseTime;
    }
}
