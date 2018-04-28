package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0531i;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.micloud.bl;

class aw extends C0531i<bl> {
    /* renamed from: a */
    final /* synthetic */ ik f2788a;
    /* renamed from: b */
    final /* synthetic */ boolean f2789b;
    /* renamed from: c */
    final /* synthetic */ boolean f2790c;
    /* renamed from: d */
    final /* synthetic */ int f2791d;
    /* renamed from: e */
    final /* synthetic */ al f2792e;
    /* renamed from: f */
    final /* synthetic */ ar f2793f;

    aw(ar arVar, ik ikVar, boolean z, boolean z2, int i, al alVar) {
        this.f2793f = arVar;
        this.f2788a = ikVar;
        this.f2789b = z;
        this.f2790c = z2;
        this.f2791d = i;
        this.f2792e = alVar;
    }

    /* renamed from: e */
    public /* synthetic */ void mo749e(C0523c c0523c) {
        m4024a((bl) c0523c);
    }

    /* renamed from: f */
    public /* synthetic */ void mo750f(C0523c c0523c) {
        m4025b((bl) c0523c);
    }

    /* renamed from: g */
    public /* synthetic */ void mo751g(C0523c c0523c) {
        m4026c((bl) c0523c);
    }

    /* renamed from: a */
    public void m4024a(bl blVar) {
        UThread.post(new ax(this, this));
    }

    /* renamed from: b */
    public void m4025b(bl blVar) {
        UThread.post(new ay(this, this));
    }

    /* renamed from: c */
    public void m4026c(bl blVar) {
        UThread.post(new az(this, this));
    }
}
