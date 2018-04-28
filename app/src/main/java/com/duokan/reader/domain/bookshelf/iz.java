package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import java.util.ArrayList;
import java.util.List;

class iz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f3374a;
    /* renamed from: b */
    final /* synthetic */ boolean f3375b;
    /* renamed from: c */
    final /* synthetic */ IAsyncWorkProgressListener f3376c;
    /* renamed from: d */
    final /* synthetic */ it f3377d;

    iz(it itVar, List list, boolean z, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.f3377d = itVar;
        this.f3374a = list;
        this.f3375b = z;
        this.f3376c = iAsyncWorkProgressListener;
    }

    public void run() {
        List arrayList = new ArrayList(this.f3374a.size());
        for (is a : this.f3374a) {
            arrayList.add(a.m4680a());
        }
        this.f3377d.f3365i.f3405b.m8113a(arrayList, this.f3375b, this.f3376c);
    }
}
