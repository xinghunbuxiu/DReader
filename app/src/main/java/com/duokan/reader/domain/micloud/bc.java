package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.C0521a;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0532j;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

class bc extends C0532j<C1073n, C1073n> {
    /* renamed from: a */
    final /* synthetic */ ba f5228a;

    bc(ba baVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.f5228a = baVar;
        super(iAsyncWorkProgressListener);
    }

    /* renamed from: a */
    public CheckErrorResult m8134a(C1073n c1073n, C0525e c0525e) {
        return C0521a.m2253a(new C1060a().m8040a(c0525e), super.mo744a(c1073n, c0525e));
    }
}
