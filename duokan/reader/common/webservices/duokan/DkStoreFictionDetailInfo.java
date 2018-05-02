package com.duokan.reader.common.webservices.duokan;

public class DkStoreFictionDetailInfo extends DkStoreItemInfo {
    public boolean mAllowFreeRead = true;
    public DkStoreFictionCategoryInfo[] mCategories = new DkStoreFictionCategoryInfo[0];
    public DkStoreFictionChapterInfo[] mChapterInfo = new DkStoreFictionChapterInfo[0];
    public String mFeeDesc = "";
    public int mFeeMode = 2;
    public DkStoreFictionInfo mFictionInfo = null;
    public DkStoreFictionInfo[] mRelatedInfo = new DkStoreFictionInfo[0];
    public String mRightId = null;
    public String mRights = null;
    public String mSummary = null;
}
