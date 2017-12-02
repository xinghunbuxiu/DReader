package com.duokan.reader.domain.downloadcenter;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.download.d;

class t implements Callback {
    final /* synthetic */ d a;
    final /* synthetic */ IDownloadTask b;
    final /* synthetic */ TaskStatus c;
    final /* synthetic */ r d;

    t(r rVar, d dVar, IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        this.d = rVar;
        this.a = dVar;
        this.b = iDownloadTask;
        this.c = taskStatus;
    }

    public boolean handleMessage(Message message) {
        this.a.a(this.b, this.c);
        return true;
    }
}
