package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.IDownloadTask;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.downloadcenter.x */
class C1036x implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IDownloadTask f5119a;
    /* renamed from: b */
    final /* synthetic */ C1030r f5120b;

    C1036x(C1030r c1030r, IDownloadTask iDownloadTask) {
        this.f5120b = c1030r;
        this.f5119a = iDownloadTask;
    }

    public void run() {
        Iterator it = this.f5120b.f5105e.iterator();
        while (it.hasNext()) {
            ((C0594d) it.next()).mo1471a(this.f5119a);
        }
    }
}
