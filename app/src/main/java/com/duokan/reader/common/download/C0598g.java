package com.duokan.reader.common.download;

import android.os.Handler.Callback;
import android.os.Message;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;

/* renamed from: com.duokan.reader.common.download.g */
class C0598g implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0594d f1998a;
    /* renamed from: b */
    final /* synthetic */ DownloadTask f1999b;
    /* renamed from: c */
    final /* synthetic */ TaskStatus f2000c;
    /* renamed from: d */
    final /* synthetic */ C0596e f2001d;

    C0598g(C0596e c0596e, C0594d c0594d, DownloadTask downloadTask, TaskStatus taskStatus) {
        this.f2001d = c0596e;
        this.f1998a = c0594d;
        this.f1999b = downloadTask;
        this.f2000c = taskStatus;
    }

    public boolean handleMessage(Message message) {
        this.f1998a.mo1473a(this.f1999b, this.f2000c);
        return true;
    }
}
