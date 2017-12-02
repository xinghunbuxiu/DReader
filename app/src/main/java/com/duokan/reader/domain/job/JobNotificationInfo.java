package com.duokan.reader.domain.job;

import android.content.Intent;

import com.duokan.b.e;

import java.io.Serializable;

public class JobNotificationInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public boolean mAutoCancel = true;
    public String mContentText;
    public String mContentTitle;
    public int mDefaultOptions = 1;
    public int mIconResId = e.mipush_small_notification;
    public int mId;
    public Intent mIntent;
    public long mTime = System.currentTimeMillis();

    public JobNotificationInfo(int i, String str, String str2, Intent intent) {
        this.mId = i;
        this.mContentTitle = str;
        this.mContentText = str2;
        this.mIntent = intent;
    }
}
