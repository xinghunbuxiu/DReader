package com.duokan.reader.domain.downloadcenter;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.d;

class s implements Callback {
    final /* synthetic */ d a;
    final /* synthetic */ IDownloadTask b;
    final /* synthetic */ r c;

    s(r rVar, d dVar, IDownloadTask iDownloadTask) {
        this.c = rVar;
        this.a = dVar;
        this.b = iDownloadTask;
    }

    public boolean handleMessage(Message message) {
        this.a.a(this.b);
        return true;
    }
}
