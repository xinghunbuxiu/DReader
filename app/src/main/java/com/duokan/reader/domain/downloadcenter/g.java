package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.IDownloadTask;

import java.util.Iterator;

class g implements Runnable {
    final /* synthetic */ IDownloadTask a;
    final /* synthetic */ b b;

    g(b bVar, IDownloadTask iDownloadTask) {
        this.b = bVar;
        this.a = iDownloadTask;
    }

    public void run() {
        Iterator it = this.b.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.a == this.a) {
                this.b.f(downloadCenterTask);
                break;
            }
        }
        this.b.t();
    }
}
