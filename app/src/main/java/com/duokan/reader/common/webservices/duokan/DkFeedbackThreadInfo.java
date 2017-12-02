package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;

public class DkFeedbackThreadInfo implements Serializable {
    public String mAuthorId = "";
    public long mDateLine = 0;
    public int mReplyCount = 0;
    public String mSubject = "";
    public String mThreadId = "";
    public boolean mValid = true;
}
