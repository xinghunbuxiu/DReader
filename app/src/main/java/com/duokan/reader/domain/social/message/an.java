package com.duokan.reader.domain.social.message;

class an implements C1140y {
    /* renamed from: a */
    final /* synthetic */ int[] f5524a;
    /* renamed from: b */
    final /* synthetic */ C1140y f5525b;
    /* renamed from: c */
    final /* synthetic */ am f5526c;

    an(am amVar, int[] iArr, C1140y c1140y) {
        this.f5526c = amVar;
        this.f5524a = iArr;
        this.f5525b = c1140y;
    }

    /* renamed from: a */
    public void mo1519a(boolean z) {
        boolean z2 = true;
        int[] iArr = this.f5524a;
        iArr[0] = iArr[0] + 1;
        if (z) {
            iArr = this.f5524a;
            iArr[1] = iArr[1] + 1;
        }
        if (this.f5524a[0] == this.f5526c.f5523a.size()) {
            C1140y c1140y = this.f5525b;
            if (this.f5524a[1] != this.f5526c.f5523a.size()) {
                z2 = false;
            }
            c1140y.mo1519a(z2);
        }
    }
}
