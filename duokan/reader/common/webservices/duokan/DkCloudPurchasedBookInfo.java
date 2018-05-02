package com.duokan.reader.common.webservices.duokan;

public class DkCloudPurchasedBookInfo extends DkCloudStoreBookInfo {
    public boolean mAd = false;
    public String[][] mLabels = ((String[][]) null);
    public DkStoreBookSourceType mType;

    public DkCloudPurchasedBookInfo(DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo) {
        super(dkCloudPurchasedBookInfo);
        this.mLabels = dkCloudPurchasedBookInfo.mLabels;
        this.mType = dkCloudPurchasedBookInfo.mType;
        this.mAd = dkCloudPurchasedBookInfo.mAd;
    }
}
