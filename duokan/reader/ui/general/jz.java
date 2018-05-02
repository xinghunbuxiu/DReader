package com.duokan.reader.ui.general;

import android.webkit.DownloadListener;

import com.duokan.common.tools;

class jz implements DownloadListener {
    final /* synthetic */ jy a;

    jz(jy jyVar) {
        this.a = jyVar;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        tools.startActivity(this.a.getContext(), str);
    }
}
