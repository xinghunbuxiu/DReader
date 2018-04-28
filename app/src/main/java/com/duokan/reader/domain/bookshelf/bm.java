package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.List;

class bm implements cu {
    /* renamed from: a */
    final /* synthetic */ ik f2844a;
    /* renamed from: b */
    final /* synthetic */ al f2845b;
    /* renamed from: c */
    final /* synthetic */ boolean f2846c;
    /* renamed from: d */
    final /* synthetic */ boolean f2847d;
    /* renamed from: e */
    final /* synthetic */ int f2848e;
    /* renamed from: f */
    final /* synthetic */ ar f2849f;

    bm(ar arVar, ik ikVar, al alVar, boolean z, boolean z2, int i) {
        this.f2849f = arVar;
        this.f2844a = ikVar;
        this.f2845b = alVar;
        this.f2846c = z;
        this.f2847d = z2;
        this.f2848e = i;
    }

    /* renamed from: a */
    public void mo987a(List<bt> list) {
        if (this.f2844a.isCancelled()) {
            this.f2849f.m3949x();
            return;
        }
        boolean z;
        al alVar = this.f2845b;
        if (this.f2846c || this.f2847d) {
            z = true;
        } else {
            z = false;
        }
        new bn(this, alVar, list, z, this.f2844a).open();
    }

    /* renamed from: a */
    public void mo986a(String str) {
        this.f2849f.m3949x();
        if (!this.f2844a.isCancelled()) {
            this.f2849f.m3933i(str);
        }
    }
}
