package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.micloud.C0812t;
import com.duokan.reader.domain.micloud.C1074o;
import com.duokan.reader.domain.micloud.bi;
import java.util.HashMap;

class hy implements C0812t {
    /* renamed from: a */
    final /* synthetic */ hw f3332a;

    hy(hw hwVar) {
        this.f3332a = hwVar;
    }

    /* renamed from: a */
    public void mo1108a(C1074o c1074o) {
    }

    /* renamed from: b */
    public void mo1110b(C1074o c1074o) {
    }

    /* renamed from: a */
    public void mo1109a(C1074o c1074o, bi biVar) {
        this.f3332a.f3330a.m3946u();
        HashMap v = this.f3332a.f3330a.m3947v();
        is isVar = new is(biVar);
        isVar.m4687g();
        UThread.post(new hz(this, (C0800c) v.get(isVar.m4686f())));
    }

    /* renamed from: b */
    public void mo1111b(C1074o c1074o, bi biVar) {
    }
}
