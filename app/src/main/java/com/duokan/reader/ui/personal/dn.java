package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.bl;

class dn implements IAsyncWorkProgressListener<bl> {
    /* renamed from: a */
    final /* synthetic */ dm f8461a;

    dn(dm dmVar) {
        this.f8461a = dmVar;
    }

    /* renamed from: d */
    public /* synthetic */ void mo748d(C0523c c0523c) {
        m11700g((bl) c0523c);
    }

    /* renamed from: e */
    public /* synthetic */ void mo749e(C0523c c0523c) {
        m11694d((bl) c0523c);
    }

    /* renamed from: g */
    public /* synthetic */ void mo751g(C0523c c0523c) {
        m11696e((bl) c0523c);
    }

    /* renamed from: a */
    public void m11688a(bl blVar) {
    }

    /* renamed from: b */
    public void m11690b(bl blVar) {
    }

    /* renamed from: c */
    public void m11692c(bl blVar) {
        it.m4692a();
        if (it.m4698a(blVar)) {
            this.f8461a.f8458c.post(new C1395do(this));
        }
    }

    /* renamed from: d */
    public void m11694d(bl blVar) {
        it.m4692a();
        if (it.m4698a(blVar)) {
            this.f8461a.m11667l();
        }
    }

    /* renamed from: a */
    public CheckErrorResult m11686a(bl blVar, C0525e c0525e) {
        return CheckErrorResult.Ignored;
    }

    /* renamed from: e */
    public void m11696e(bl blVar) {
        it.m4692a();
        if (it.m4698a(blVar)) {
            this.f8461a.m11667l();
        }
    }

    /* renamed from: f */
    public void m11698f(bl blVar) {
        it.m4692a();
        if (it.m4698a(blVar)) {
            this.f8461a.f8458c.post(new dp(this));
        }
    }

    /* renamed from: g */
    public void m11700g(bl blVar) {
        it.m4692a();
        if (it.m4698a(blVar)) {
            this.f8461a.f8458c.post(new dq(this));
        }
    }
}
