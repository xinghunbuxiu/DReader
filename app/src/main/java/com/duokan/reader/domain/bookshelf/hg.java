package com.duokan.reader.domain.bookshelf;

import com.duokan.core.p029c.IRunTask;

class hg implements IRunTask<C0800c> {
    /* renamed from: a */
    final /* synthetic */ hc f3300a;

    hg(hc hcVar) {
        this.f3300a = hcVar;
    }

    /* renamed from: a */
    public boolean m4634a(C0800c c0800c) {
        return c0800c.aq() != -1 && c0800c.m4233i() == BookState.CLOUD_ONLY;
    }
}
