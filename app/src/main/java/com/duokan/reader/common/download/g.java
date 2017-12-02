package com.duokan.reader.common.download;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.common.download.IDownloadTask.TaskStatus;

class g implements Callback {
    final /* synthetic */ d a;
    final /* synthetic */ DownloadTask b;
    final /* synthetic */ TaskStatus c;
    final /* synthetic */ e d;

    g(e eVar, d dVar, DownloadTask downloadTask, TaskStatus taskStatus) {
        this.d = eVar;
        this.a = dVar;
        this.b = downloadTask;
        this.c = taskStatus;
    }

    public boolean handleMessage(Message message) {
        this.a.a(this.b, this.c);
        return true;
    }
}
