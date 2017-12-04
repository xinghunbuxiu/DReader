package com.duokan.reader.ui.general.web;

import android.webkit.DownloadListener;

import com.duokan.common.tools;

class i implements DownloadListener {
    final /* synthetic */ DkWebView a;

    i(DkWebView dkWebView) {
        this.a = dkWebView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        tools.startActivity(this.a.getContext(), str);
    }
}
