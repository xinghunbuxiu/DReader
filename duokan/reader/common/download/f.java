package com.duokan.reader.common.download;

import android.os.Handler.Callback;
import android.os.Message;

class f implements Callback {
    final /* synthetic */ d a;
    final /* synthetic */ DownloadTask b;
    final /* synthetic */ e c;

    f(e eVar, d dVar, DownloadTask downloadTask) {
        this.c = eVar;
        this.a = dVar;
        this.b = downloadTask;
    }

    public boolean handleMessage(Message message) {
        this.a.a(this.b);
        return true;
    }
}
