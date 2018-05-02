package com.duokan.reader.domain.job;

import java.io.Serializable;

public final class JobInfo implements Serializable {
    protected int mExecCount = 0;
    protected long mExpirationTime = 0;
    protected int mFlags = 0;
    protected long mInitialTime = 0;
    protected long mIntervalTime = 0;
    protected final Class mJobClass;
    protected final String mJobName;
    protected Serializable mParams = null;
    protected int mRepeatCount = 0;

    protected JobInfo(String str, Class cls) {
        this.mJobName = str;
        this.mJobClass = cls;
    }

    public String getJobName() {
        return this.mJobName;
    }

    public Object getParams() {
        return this.mParams;
    }
}
