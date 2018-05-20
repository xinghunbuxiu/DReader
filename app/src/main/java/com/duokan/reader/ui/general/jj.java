package com.duokan.reader.ui.general;

import android.webkit.DownloadListener;
import com.duokan.common.CommonUtils;

class jj implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ ji f7447a;

    jj(ji jiVar) {
        this.f7447a = jiVar;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        CommonUtils.m602a(this.f7447a.getContext(), str);
    }
}
