package com.duokan.reader.common.async.work;

public interface IAsyncWorkProgressListener<TItem extends C0523c> {

    public enum CheckErrorResult {
        Ignored,
        Passed,
        Failed
    }

    /* renamed from: a */
    CheckErrorResult mo744a(TItem tItem, C0525e c0525e);

    /* renamed from: a */
    void mo745a(TItem tItem);

    /* renamed from: b */
    void mo746b(TItem tItem);

    /* renamed from: c */
    void mo747c(TItem tItem);

    /* renamed from: d */
    void mo748d(TItem tItem);

    /* renamed from: e */
    void mo749e(TItem tItem);

    /* renamed from: f */
    void mo750f(TItem tItem);

    /* renamed from: g */
    void mo751g(TItem tItem);
}
