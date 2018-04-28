package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.domain.micloud.C1073n;

class ed implements IAsyncWorkProgressListener<C1073n> {
    /* renamed from: a */
    final /* synthetic */ ej f8492a;
    /* renamed from: b */
    final /* synthetic */ dm f8493b;

    ed(dm dmVar, ej ejVar) {
        this.f8493b = dmVar;
        this.f8492a = ejVar;
    }

    /* renamed from: a */
    public /* synthetic */ void mo745a(C0523c c0523c) {
        m11726b((C1073n) c0523c);
    }

    /* renamed from: b */
    public /* synthetic */ void mo746b(C0523c c0523c) {
        m11734f((C1073n) c0523c);
    }

    /* renamed from: e */
    public /* synthetic */ void mo749e(C0523c c0523c) {
        m11724a((C1073n) c0523c);
    }

    /* renamed from: f */
    public /* synthetic */ void mo750f(C0523c c0523c) {
        m11736g((C1073n) c0523c);
    }

    /* renamed from: g */
    public /* synthetic */ void mo751g(C0523c c0523c) {
        m11732e((C1073n) c0523c);
    }

    /* renamed from: a */
    public void m11724a(C1073n c1073n) {
        this.f8493b.f8458c.post(new ee(this, c1073n.m8255y()));
    }

    /* renamed from: b */
    public void m11726b(C1073n c1073n) {
    }

    /* renamed from: c */
    public void m11728c(C1073n c1073n) {
    }

    /* renamed from: d */
    public void m11730d(C1073n c1073n) {
    }

    /* renamed from: e */
    public void m11732e(C1073n c1073n) {
        this.f8493b.f8458c.post(new ef(this, c1073n.m8255y()));
    }

    /* renamed from: f */
    public void m11734f(C1073n c1073n) {
    }

    /* renamed from: a */
    public CheckErrorResult m11722a(C1073n c1073n, C0525e c0525e) {
        return CheckErrorResult.Ignored;
    }

    /* renamed from: g */
    public void m11736g(C1073n c1073n) {
        this.f8493b.f8458c.post(new eg(this, c1073n.m8255y()));
    }
}
