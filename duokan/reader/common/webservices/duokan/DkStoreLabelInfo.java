package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;

public class DkStoreLabelInfo extends DkStoreItemInfo {
    public static final String NATIVE_TAG = "native://";
    public boolean mDefaultActive = false;
    public String mLabel = "";
    public String mUrl = NATIVE_TAG;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DkStoreLabelInfo)) {
            return false;
        }
        DkStoreLabelInfo dkStoreLabelInfo = (DkStoreLabelInfo) obj;
        if (TextUtils.equals(this.mLabel, dkStoreLabelInfo.mLabel) && TextUtils.equals(this.mUrl, dkStoreLabelInfo.mUrl) && this.mDefaultActive == dkStoreLabelInfo.mDefaultActive) {
            return true;
        }
        return false;
    }
}
