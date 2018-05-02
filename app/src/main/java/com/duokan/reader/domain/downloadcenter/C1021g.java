package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.IDownloadTask;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.downloadcenter.g */
class C1021g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IDownloadTask f5072a;
    /* renamed from: b */
    final /* synthetic */ C1016b f5073b;

    C1021g(C1016b c1016b, IDownloadTask iDownloadTask) {
        this.f5073b = c1016b;
        this.f5072a = iDownloadTask;
    }

    public void run() {
        Iterator it = this.f5073b.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.f5029a == this.f5072a) {
                this.f5073b.m7854f(downloadCenterTask);
                break;
            }
        }
        this.f5073b.m7860v();
    }
}
