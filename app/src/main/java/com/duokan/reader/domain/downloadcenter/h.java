package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask.TaskResult;

import java.util.Iterator;

class h implements Runnable {
    final /* synthetic */ IDownloadTask a;
    final /* synthetic */ TaskResult b;
    final /* synthetic */ b c;

    h(b bVar, IDownloadTask iDownloadTask, TaskResult taskResult) {
        this.c = bVar;
        this.a = iDownloadTask;
        this.b = taskResult;
    }

    public void run() {
        Iterator it = this.c.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.a == this.a) {
                if (this.b != TaskResult.NONE) {
                    downloadCenterTask.a(this.b);
                }
                this.c.f(downloadCenterTask);
                return;
            }
        }
    }
}
