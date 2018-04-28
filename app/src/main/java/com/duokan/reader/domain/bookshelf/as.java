package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.C0613k;
import com.duokan.reader.common.async.p035a.C0517a;

class as implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ C0613k f2773a;
    /* renamed from: b */
    final /* synthetic */ boolean f2774b;
    /* renamed from: c */
    final /* synthetic */ boolean f2775c;
    /* renamed from: d */
    final /* synthetic */ ar f2776d;

    as(ar arVar, C0613k c0613k, boolean z, boolean z2) {
        this.f2776d = arVar;
        this.f2773a = c0613k;
        this.f2774b = z;
        this.f2775c = z2;
    }

    /* renamed from: a */
    public void m4017a(Void voidR) {
        this.f2773a.m2796a(Integer.valueOf(((Integer) this.f2773a.m2795a()).intValue() + 1));
        if (((Integer) this.f2773a.m2795a()).intValue() == 3) {
            this.f2776d.m3949x();
            try {
                this.f2776d.k.mo1090a();
                this.f2776d.m3960a(this.f2774b, this.f2775c, 0);
            } finally {
                this.f2776d.k.mo1096b();
            }
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
    }
}
