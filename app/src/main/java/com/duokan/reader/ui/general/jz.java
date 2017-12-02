package com.duokan.reader.ui.general;

import android.webkit.DownloadListener;

import com.duokan.common.i;

class jz implements DownloadListener {
    final /* synthetic */ jy a;

    jz(jy jyVar) {
        this.a = jyVar;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        i.a(this.a.getContext(), str);
    }
}
