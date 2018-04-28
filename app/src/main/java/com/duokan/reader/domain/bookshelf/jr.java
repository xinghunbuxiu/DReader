package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.C0521a;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.domain.micloud.C1068i;
import java.util.Iterator;

class jr implements IAsyncWorkProgressListener<C1068i> {
    /* renamed from: a */
    final /* synthetic */ jp f3412a;

    jr(jp jpVar) {
        this.f3412a = jpVar;
    }

    /* renamed from: a */
    public void m4769a(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo745a(c1068i);
        }
    }

    /* renamed from: b */
    public void m4771b(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo746b(c1068i);
        }
    }

    /* renamed from: c */
    public void m4773c(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo747c(c1068i);
        }
    }

    /* renamed from: d */
    public void m4775d(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo748d(c1068i);
        }
    }

    /* renamed from: e */
    public void m4777e(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo749e(c1068i);
        }
    }

    /* renamed from: f */
    public void m4779f(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo750f(c1068i);
        }
    }

    /* renamed from: a */
    public CheckErrorResult m4767a(C1068i c1068i, C0525e c0525e) {
        CheckErrorResult checkErrorResult = CheckErrorResult.Ignored;
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        CheckErrorResult checkErrorResult2 = checkErrorResult;
        while (it.hasNext()) {
            checkErrorResult2 = C0521a.m2253a(checkErrorResult2, ((IAsyncWorkProgressListener) it.next()).mo744a(c1068i, c0525e));
        }
        return checkErrorResult2;
    }

    /* renamed from: g */
    public void m4781g(C1068i c1068i) {
        Iterator it = this.f3412a.f3408e.f3362f.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo751g(c1068i);
        }
    }
}
