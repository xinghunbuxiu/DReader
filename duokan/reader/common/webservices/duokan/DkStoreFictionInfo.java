package com.duokan.reader.common.webservices.duokan;

import java.util.Date;

public class DkStoreFictionInfo extends DkStoreAbsBookInfo {
    public int mAdTime = -1;
    public String[] mAuthorIds = new String[0];
    public DkStoreFictionCategoryInfo[] mCategories = new DkStoreFictionCategoryInfo[0];
    public int mChapterCount = 0;
    public int mClick = 0;
    public String mDescription = null;
    public boolean mFinish = false;
    public boolean mHasAds = false;
    public String mLatest = null;
    public String mLatestId = null;
    public boolean mOnSale = true;
    public int mPageLevel = 0;
    public int mPrice = 0;
    public String mRights = null;
    public int mRiseCount = 0;
    public float mSpecial = -1.0f;
    public String mTypeId = "";
    public Date mUpdated = new Date();
    public long mWordCount = 0;
}
