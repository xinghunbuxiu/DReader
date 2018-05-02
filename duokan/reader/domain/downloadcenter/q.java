package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.domain.micloud.aa;
import com.duokan.reader.domain.micloud.z;

class q implements IAsyncWorkProgressListener {
    final /* synthetic */ aa a;
    final /* synthetic */ p b;

    q(p pVar, aa aaVar) {
        this.b = pVar;
        this.a = aaVar;
    }

    public void a(z zVar) {
    }

    public void b(z zVar) {
        TaskStatus taskStatus;
        synchronized (this.b) {
            taskStatus = TaskStatus.RUNNING;
            this.b.i = taskStatus;
        }
        this.b.a(taskStatus);
    }

    public void c(z zVar) {
        this.b.k();
    }

    public void d(z zVar) {
        TaskStatus taskStatus;
        this.a.b(zVar, this);
        synchronized (this.b) {
            taskStatus = zVar.k() ? TaskStatus.PAUSED : TaskStatus.STOPPED;
            this.b.i = taskStatus;
        }
        this.b.a(taskStatus);
    }

    public void e(z zVar) {
        TaskStatus taskStatus;
        TaskState taskState;
        this.a.b(zVar, this);
        synchronized (this.b) {
            taskStatus = TaskStatus.STOPPED;
            taskState = TaskState.SUCCEEDED;
            this.b.i = taskStatus;
            this.b.j = taskState;
        }
        this.b.a(taskStatus);
        this.b.a(taskState);
    }

    public void f(z zVar) {
        TaskStatus taskStatus;
        TaskState taskState;
        this.a.b(zVar, this);
        synchronized (this.b) {
            taskStatus = TaskStatus.STOPPED;
            taskState = TaskState.UNFINISHED;
            this.b.i = taskStatus;
            this.b.j = taskState;
            this.b.h = null;
        }
        this.b.a(taskStatus);
        this.b.a(taskState);
    }

    public CheckErrorResult a(z zVar, e eVar) {
        return CheckErrorResult.Ignored;
    }

    public void g(z zVar) {
        TaskStatus taskStatus;
        TaskState taskState;
        this.a.b(zVar, this);
        synchronized (this.b) {
            taskStatus = TaskStatus.STOPPED;
            taskState = TaskState.FAILED;
            this.b.i = taskStatus;
            this.b.j = taskState;
        }
        this.b.a(taskStatus);
        this.b.a(taskState);
    }
}
