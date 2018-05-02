package com.duokan.reader.common.download;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.duokan.reader.common.download.f */
class C0597f implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0594d f1995a;
    /* renamed from: b */
    final /* synthetic */ DownloadTask f1996b;
    /* renamed from: c */
    final /* synthetic */ C0596e f1997c;

    C0597f(C0596e c0596e, C0594d c0594d, DownloadTask downloadTask) {
        this.f1997c = c0596e;
        this.f1995a = c0594d;
        this.f1996b = downloadTask;
    }

    public boolean handleMessage(Message message) {
        this.f1995a.mo1471a(this.f1996b);
        return true;
    }
}
