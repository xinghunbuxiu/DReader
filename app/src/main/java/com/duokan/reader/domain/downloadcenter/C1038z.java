package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.downloadcenter.z */
class C1038z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IDownloadTask f5124a;
    /* renamed from: b */
    final /* synthetic */ TaskState f5125b;
    /* renamed from: c */
    final /* synthetic */ C1030r f5126c;

    C1038z(C1030r c1030r, IDownloadTask iDownloadTask, TaskState taskState) {
        this.f5126c = c1030r;
        this.f5124a = iDownloadTask;
        this.f5125b = taskState;
    }

    public void run() {
        Iterator it = this.f5126c.f5105e.iterator();
        while (it.hasNext()) {
            ((C0594d) it.next()).mo1472a(this.f5124a, this.f5125b);
        }
    }
}
