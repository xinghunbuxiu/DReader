package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.List;

class bi implements dw {
    /* renamed from: a */
    final /* synthetic */ ik f2825a;
    /* renamed from: b */
    final /* synthetic */ al f2826b;
    /* renamed from: c */
    final /* synthetic */ boolean f2827c;
    /* renamed from: d */
    final /* synthetic */ boolean f2828d;
    /* renamed from: e */
    final /* synthetic */ int f2829e;
    /* renamed from: f */
    final /* synthetic */ ar f2830f;

    bi(ar arVar, ik ikVar, al alVar, boolean z, boolean z2, int i) {
        this.f2830f = arVar;
        this.f2825a = ikVar;
        this.f2826b = alVar;
        this.f2827c = z;
        this.f2828d = z2;
        this.f2829e = i;
    }

    /* renamed from: a */
    public void mo983a(List<dd> list) {
        if (this.f2825a.isCancelled()) {
            this.f2830f.m3949x();
        } else {
            new bj(this, this.f2826b, list, this.f2825a).open();
        }
    }

    /* renamed from: a */
    public void mo982a(String str) {
        this.f2830f.m3949x();
        if (!this.f2825a.isCancelled()) {
            this.f2830f.m3933i(str);
        }
    }
}
