package com.duokan.reader.ui.general.web;

import android.webkit.DownloadListener;
import com.duokan.common.CommonUtils;

/* renamed from: com.duokan.reader.ui.general.web.i */
class C1361i implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ DkWebView f7962a;

    C1361i(DkWebView dkWebView) {
        this.f7962a = dkWebView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        CommonUtils.m602a(this.f7962a.getContext(), str);
    }
}
