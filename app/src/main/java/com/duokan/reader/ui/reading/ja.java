package com.duokan.reader.ui.reading;

import android.graphics.RectF;

class ja implements jk {
    /* renamed from: a */
    final /* synthetic */ jc f10419a;
    /* renamed from: b */
    final /* synthetic */ iz f10420b;

    ja(iz izVar, jc jcVar) {
        this.f10420b = izVar;
        this.f10419a = jcVar;
    }

    /* renamed from: a */
    public void mo2394a() {
        this.f10420b.requestBack();
    }

    /* renamed from: b */
    public void mo2396b() {
        this.f10420b.requestBack();
        this.f10419a.mo2463a();
    }

    /* renamed from: a */
    public void mo2395a(RectF rectF, boolean z) {
        this.f10420b.requestBack();
        RectF[] rectFArr = new RectF[2];
        rectFArr[0] = rectF;
        if (!z) {
            rectF = new RectF(rectF.right, rectF.top, rectF.left, rectF.bottom);
        }
        rectFArr[1] = rectF;
        this.f10419a.mo2464a(rectFArr);
    }
}
