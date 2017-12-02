package com.duokan.reader.domain.downloadcenter;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.d;

class u implements Callback {
    final /* synthetic */ d a;
    final /* synthetic */ IDownloadTask b;
    final /* synthetic */ TaskState c;
    final /* synthetic */ r d;

    u(r rVar, d dVar, IDownloadTask iDownloadTask, TaskState taskState) {
        this.d = rVar;
        this.a = dVar;
        this.b = iDownloadTask;
        this.c = taskState;
    }

    public boolean handleMessage(Message message) {
        this.a.a(this.b, this.c);
        return true;
    }
}
