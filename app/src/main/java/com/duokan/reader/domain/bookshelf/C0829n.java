package com.duokan.reader.domain.bookshelf;

import android.os.AsyncTask;

/* renamed from: com.duokan.reader.domain.bookshelf.n */
class C0829n extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ C0800c f3570a;
    /* renamed from: b */
    final /* synthetic */ C0798a[] f3571b;
    /* renamed from: c */
    final /* synthetic */ C0806u f3572c;
    /* renamed from: d */
    final /* synthetic */ C0800c f3573d;

    C0829n(C0800c c0800c, C0800c c0800c2, C0798a[] c0798aArr, C0806u c0806u) {
        this.f3573d = c0800c;
        this.f3570a = c0800c2;
        this.f3571b = c0798aArr;
        this.f3572c = c0806u;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4967a((Void[]) objArr);
    }

    /* renamed from: a */
    protected Void m4967a(Void... voidArr) {
        this.f3573d.m4132a(this.f3570a, this.f3571b, new C0830o(this));
        return null;
    }
}
