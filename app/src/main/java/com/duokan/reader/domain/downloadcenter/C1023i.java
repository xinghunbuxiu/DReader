package com.duokan.reader.domain.downloadcenter;

import com.duokan.core.sys.UThread;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.downloadcenter.i */
class C1023i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1016b f5077a;

    C1023i(C1016b c1016b) {
        this.f5077a = c1016b;
    }

    public void run() {
        Iterator it = this.f5077a.f5058f.iterator();
        Object obj = null;
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7790d()) {
                obj = 1;
                this.f5077a.m7852e(downloadCenterTask);
            }
            obj = obj;
        }
        if (obj != null) {
            UThread.postDelayed((Runnable) this, 1000);
            return;
        }
        UThread.removeCallbacks(this.f5077a.f5061i);
        this.f5077a.f5061i = null;
    }
}
