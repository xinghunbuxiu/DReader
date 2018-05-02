package com.duokan.reader.domain.social.message;

/* renamed from: com.duokan.reader.domain.social.message.w */
class C1162w implements C1140y {
    /* renamed from: a */
    final /* synthetic */ int[] f5586a;
    /* renamed from: b */
    final /* synthetic */ C1140y f5587b;
    /* renamed from: c */
    final /* synthetic */ C1161v f5588c;

    C1162w(C1161v c1161v, int[] iArr, C1140y c1140y) {
        this.f5588c = c1161v;
        this.f5586a = iArr;
        this.f5587b = c1140y;
    }

    /* renamed from: a */
    public void mo1519a(boolean z) {
        boolean z2 = true;
        int[] iArr = this.f5586a;
        iArr[0] = iArr[0] + 1;
        if (z) {
            iArr = this.f5586a;
            iArr[1] = iArr[1] + 1;
        }
        if (this.f5586a[0] == this.f5588c.f5585a.size()) {
            C1140y c1140y = this.f5587b;
            if (this.f5586a[1] != this.f5588c.f5585a.size()) {
                z2 = false;
            }
            c1140y.mo1519a(z2);
        }
    }
}
