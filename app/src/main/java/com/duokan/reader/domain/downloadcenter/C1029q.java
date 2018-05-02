package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.domain.micloud.C1084z;
import com.duokan.reader.domain.micloud.aa;

/* renamed from: com.duokan.reader.domain.downloadcenter.q */
class C1029q implements IAsyncWorkProgressListener<C1084z> {
    /* renamed from: a */
    final /* synthetic */ aa f5099a;
    /* renamed from: b */
    final /* synthetic */ C1028p f5100b;

    C1029q(C1028p c1028p, aa aaVar) {
        this.f5100b = c1028p;
        this.f5099a = aaVar;
    }

    /* renamed from: a */
    public void m7933a(C1084z c1084z) {
    }

    /* renamed from: b */
    public void m7935b(C1084z c1084z) {
        TaskStatus taskStatus;
        synchronized (this.f5100b) {
            taskStatus = TaskStatus.RUNNING;
            this.f5100b.f5097i = taskStatus;
        }
        this.f5100b.m7913a(taskStatus);
    }

    /* renamed from: c */
    public void m7937c(C1084z c1084z) {
        this.f5100b.m7925k();
    }

    /* renamed from: d */
    public void m7939d(C1084z c1084z) {
        TaskStatus taskStatus;
        this.f5099a.m2365b(c1084z, this);
        synchronized (this.f5100b) {
            taskStatus = c1084z.m2296k() ? TaskStatus.PAUSED : TaskStatus.STOPPED;
            this.f5100b.f5097i = taskStatus;
        }
        this.f5100b.m7913a(taskStatus);
    }

    /* renamed from: e */
    public void m7941e(C1084z c1084z) {
        TaskStatus taskStatus;
        TaskState taskState;
        this.f5099a.m2365b(c1084z, this);
        synchronized (this.f5100b) {
            taskStatus = TaskStatus.STOPPED;
            taskState = TaskState.SUCCEEDED;
            this.f5100b.f5097i = taskStatus;
            this.f5100b.f5098j = taskState;
        }
        this.f5100b.m7913a(taskStatus);
        this.f5100b.m7912a(taskState);
    }

    /* renamed from: f */
    public void m7943f(C1084z c1084z) {
        TaskStatus taskStatus;
        TaskState taskState;
        this.f5099a.m2365b(c1084z, this);
        synchronized (this.f5100b) {
            taskStatus = TaskStatus.STOPPED;
            taskState = TaskState.UNFINISHED;
            this.f5100b.f5097i = taskStatus;
            this.f5100b.f5098j = taskState;
            this.f5100b.f5096h = null;
        }
        this.f5100b.m7913a(taskStatus);
        this.f5100b.m7912a(taskState);
    }

    /* renamed from: a */
    public CheckErrorResult m7931a(C1084z c1084z, C0525e c0525e) {
        return CheckErrorResult.Ignored;
    }

    /* renamed from: g */
    public void m7945g(C1084z c1084z) {
        TaskStatus taskStatus;
        TaskState taskState;
        this.f5099a.m2365b(c1084z, this);
        synchronized (this.f5100b) {
            taskStatus = TaskStatus.STOPPED;
            taskState = TaskState.FAILED;
            this.f5100b.f5097i = taskStatus;
            this.f5100b.f5098j = taskState;
        }
        this.f5100b.m7913a(taskStatus);
        this.f5100b.m7912a(taskState);
    }
}
