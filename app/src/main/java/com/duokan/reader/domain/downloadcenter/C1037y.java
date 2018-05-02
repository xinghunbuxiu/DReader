package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.downloadcenter.y */
class C1037y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IDownloadTask f5121a;
    /* renamed from: b */
    final /* synthetic */ TaskStatus f5122b;
    /* renamed from: c */
    final /* synthetic */ C1030r f5123c;

    C1037y(C1030r c1030r, IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        this.f5123c = c1030r;
        this.f5121a = iDownloadTask;
        this.f5122b = taskStatus;
    }

    public void run() {
        Iterator it = this.f5123c.f5105e.iterator();
        while (it.hasNext()) {
            ((C0594d) it.next()).mo1473a(this.f5121a, this.f5122b);
        }
    }
}
