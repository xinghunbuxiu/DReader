package com.duokan.reader.common.webservices.duokan;

import java.util.Date;

public class DkStoreBookInfo extends DkStoreAbsBookInfo {
    public static final String PLATFORM = "Android";
    public boolean mAndroidPlatformValid = true;
    public String[] mAuthorIds = new String[0];
    public float mAverageScore = 0.0f;
    public int mCommentCount = -1;
    public String mDescription = null;
    public String[] mEditors = new String[0];
    public String mExpandInfo = null;
    public Date mExpirationDate = null;
    public boolean mHasChangeLog = false;
    public long mLimitedTime = 0;
    public int mNewPrice = 0;
    public int mPrice = 0;
    public String mRevision = null;
    public int mScoreCount = 0;
    public int mSource = 1;
    public String mSourceId = null;
    public long mTime = 0;
    public int mWeight = 0;
}
