package com.duokan.reader.common.download;

import android.os.Handler.Callback;
import android.os.Message;
import com.duokan.reader.common.download.IDownloadTask.TaskState;

/* renamed from: com.duokan.reader.common.download.h */
class C0599h implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0594d f2002a;
    /* renamed from: b */
    final /* synthetic */ DownloadTask f2003b;
    /* renamed from: c */
    final /* synthetic */ TaskState f2004c;
    /* renamed from: d */
    final /* synthetic */ C0596e f2005d;

    C0599h(C0596e c0596e, C0594d c0594d, DownloadTask downloadTask, TaskState taskState) {
        this.f2005d = c0596e;
        this.f2002a = c0594d;
        this.f2003b = downloadTask;
        this.f2004c = taskState;
    }

    public boolean handleMessage(Message message) {
        this.f2002a.mo1472a(this.f2003b, this.f2004c);
        return true;
    }
}
