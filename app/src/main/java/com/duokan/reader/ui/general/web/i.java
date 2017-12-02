package com.duokan.reader.ui.general.web;

import android.webkit.DownloadListener;

class i implements DownloadListener {
    final /* synthetic */ DkWebView a;

    i(DkWebView dkWebView) {
        this.a = dkWebView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        com.duokan.common.i.a(this.a.getContext(), str);
    }
}
