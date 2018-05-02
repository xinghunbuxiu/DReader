package com.duokan.reader.common.webservices.duokan;

import java.util.Date;

public class DkAnnotationBookInfo extends DkStoreItemInfo {
    public String mAuthor = null;
    public String mBookName = null;
    public String mBookUuid = null;
    public int mBookmarkCount = 0;
    public int mCommentCount = 0;
    public String mCoverUrl = null;
    public String mEditor = null;
    public Date mLastUpdateTime = new Date();
    public boolean mSerial = false;
    public long mVersion = 0;
}
