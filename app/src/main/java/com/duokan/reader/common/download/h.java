package com.duokan.reader.common.download;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.common.download.IDownloadTask.TaskState;

class h implements Callback {
    final /* synthetic */ d a;
    final /* synthetic */ DownloadTask b;
    final /* synthetic */ TaskState c;
    final /* synthetic */ e d;

    h(e eVar, d dVar, DownloadTask downloadTask, TaskState taskState) {
        this.d = eVar;
        this.a = dVar;
        this.b = downloadTask;
        this.c = taskState;
    }

    public boolean handleMessage(Message message) {
        this.a.a(this.b, this.c);
        return true;
    }
}
