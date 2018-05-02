package com.duokan.reader.domain.downloadcenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.duokan.reader.common.classc;

import java.util.Collection;

class c extends Handler {
    final /* synthetic */ b a;

    c(b bVar, Looper looper) {
        this.a = bVar;
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
                if (downloadCenterTask.c() && (classc.ConnectivityReceiver.b().d() || this.a.h(downloadCenterTask))) {
                    this.a.b(downloadCenterTask);
                }
                if (collection.size() > 0) {
                    sendMessageDelayed(this.a.n.obtainMessage(0, collection), 0);
                }
            }
        } else if (message.what == 1) {
            collection = (Collection) message.obj;
            if (collection.size() > 0) {
                downloadCenterTask = (DownloadCenterTask) collection.iterator().next();
                collection.remove(downloadCenterTask);
                if (downloadCenterTask.e() && classc.ConnectivityReceiver.b().c() && !this.a.h(downloadCenterTask)) {
                    this.a.g(downloadCenterTask);
                }
                if (collection.size() > 0) {
                    sendMessageDelayed(this.a.n.obtainMessage(1, collection), 0);
                }
            }
        }
    }
}
