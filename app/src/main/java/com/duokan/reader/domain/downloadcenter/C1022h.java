package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask.TaskResult;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.downloadcenter.h */
class C1022h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IDownloadTask f5074a;
    /* renamed from: b */
    final /* synthetic */ TaskResult f5075b;
    /* renamed from: c */
    final /* synthetic */ C1016b f5076c;

    C1022h(C1016b c1016b, IDownloadTask iDownloadTask, TaskResult taskResult) {
        this.f5076c = c1016b;
        this.f5074a = iDownloadTask;
        this.f5075b = taskResult;
    }

    public void run() {
        Iterator it = this.f5076c.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.f5029a == this.f5074a) {
                if (this.f5075b != TaskResult.NONE) {
                    downloadCenterTask.m7786a(this.f5075b);
                }
                this.f5076c.m7854f(downloadCenterTask);
                return;
            }
        }
    }
}
