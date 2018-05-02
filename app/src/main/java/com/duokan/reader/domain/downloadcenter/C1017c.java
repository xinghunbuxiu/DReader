package com.duokan.reader.domain.downloadcenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.duokan.reader.common.p037c.C0559f;
import java.util.Collection;

/* renamed from: com.duokan.reader.domain.downloadcenter.c */
class C1017c extends Handler {
    /* renamed from: a */
    final /* synthetic */ C1016b f5067a;

    C1017c(C1016b c1016b, Looper looper) {
        this.f5067a = c1016b;
        super(looper);
    }

    public void handleMessage(Message message) {
        Collection collection;
        DownloadCenterTask downloadCenterTask;
        if (message.what == 0) {
            collection = (Collection) message.obj;
            if (collection.size() > 0) {
                downloadCenterTask = (DownloadCenterTask) collection.iterator().next();
                collection.remove(downloadCenterTask);
                if (downloadCenterTask.m7789c() && (C0559f.m2476b().m2485d() || this.f5067a.m7856h(downloadCenterTask))) {
                    this.f5067a.m7879b(downloadCenterTask);
                }
                if (collection.size() > 0) {
                    sendMessageDelayed(this.f5067a.f5066n.obtainMessage(0, collection), 0);
                }
            }
        } else if (message.what == 1) {
            collection = (Collection) message.obj;
            if (collection.size() > 0) {
                downloadCenterTask = (DownloadCenterTask) collection.iterator().next();
                collection.remove(downloadCenterTask);
                if (downloadCenterTask.m7791e() && C0559f.m2476b().m2484c() && !this.f5067a.m7856h(downloadCenterTask)) {
                    this.f5067a.m7855g(downloadCenterTask);
                }
                if (collection.size() > 0) {
                    sendMessageDelayed(this.f5067a.f5066n.obtainMessage(1, collection), 0);
                }
            }
        }
    }
}
