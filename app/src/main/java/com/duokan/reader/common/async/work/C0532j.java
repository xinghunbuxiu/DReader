package com.duokan.reader.common.async.work;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

/* renamed from: com.duokan.reader.common.async.work.j */
public class C0532j<TStubItem extends C0523c, TItem extends TStubItem> implements IAsyncWorkProgressListener<TItem> {
    /* renamed from: a */
    private final IAsyncWorkProgressListener<TStubItem> f1781a;

    public C0532j(IAsyncWorkProgressListener<TStubItem> iAsyncWorkProgressListener) {
        this.f1781a = iAsyncWorkProgressListener;
    }

    /* renamed from: a */
    public void mo745a(TItem tItem) {
        this.f1781a.mo745a(tItem);
    }

    /* renamed from: b */
    public void mo746b(TItem tItem) {
        this.f1781a.mo746b(tItem);
    }

    /* renamed from: c */
    public void mo747c(TItem tItem) {
        this.f1781a.mo747c(tItem);
    }

    /* renamed from: d */
    public void mo748d(TItem tItem) {
        this.f1781a.mo748d(tItem);
    }

    /* renamed from: e */
    public void mo749e(TItem tItem) {
        this.f1781a.mo749e(tItem);
    }

    /* renamed from: f */
    public void mo750f(TItem tItem) {
        this.f1781a.mo750f(tItem);
    }

    /* renamed from: a */
    public CheckErrorResult mo744a(TItem tItem, C0525e c0525e) {
        return this.f1781a.mo744a(tItem, c0525e);
    }

    /* renamed from: g */
    public void mo751g(TItem tItem) {
        this.f1781a.mo751g(tItem);
    }
}
