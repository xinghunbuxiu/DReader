package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0531i;
import com.duokan.reader.domain.micloud.C1068i;

class ia extends C0531i<C1068i> {
    /* renamed from: a */
    final /* synthetic */ hw f3336a;

    ia(hw hwVar) {
        this.f3336a = hwVar;
    }

    /* renamed from: e */
    public /* synthetic */ void mo749e(C0523c c0523c) {
        m4670a((C1068i) c0523c);
    }

    /* renamed from: a */
    public void m4670a(C1068i c1068i) {
        super.mo749e(c1068i);
        this.f3336a.f3330a.m3946u();
        UThread.post(new ib(this, c1068i, new is(c1068i.m8212H())));
    }
}
