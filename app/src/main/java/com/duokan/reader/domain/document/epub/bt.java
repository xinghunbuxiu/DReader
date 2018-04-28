package com.duokan.reader.domain.document.epub;

import android.graphics.PointF;
import android.graphics.Rect;
import com.duokan.kernel.epublib.DkeCalloutInfo;
import com.duokan.kernel.epublib.DkeMultiCallout;
import com.duokan.reader.domain.document.C0931c;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.az;

class bt extends bu implements aj {
    /* renamed from: a */
    final /* synthetic */ az f4608a;
    /* renamed from: m */
    private final DkeMultiCallout f4609m;
    /* renamed from: n */
    private final Rect f4610n;
    /* renamed from: o */
    private final C0931c[] f4611o;

    private bt(az azVar, DkeMultiCallout dkeMultiCallout) {
        this.f4608a = azVar;
        super(azVar, dkeMultiCallout.getBaseImageInfo());
        this.f4609m = dkeMultiCallout;
        this.f4611o = new C0931c[this.f4609m.getCalloutCount()];
        this.f4610n = this.f4609m.getBaseImageInfo().mBoundingBox.toRect();
        m6756d();
    }

    /* renamed from: b */
    public void mo1417b() {
        this.f4609m.recycle();
        super.mo1417b();
    }

    /* renamed from: a */
    public C0931c mo1416a(int i) {
        return this.f4611o[i];
    }

    /* renamed from: a */
    public int mo1415a() {
        return this.f4611o.length;
    }

    /* renamed from: c */
    public Rect m6760c() {
        return this.f4609m.getNavigationBox().toRect();
    }

    /* renamed from: d */
    private void m6756d() {
        for (int i = 0; i < this.f4611o.length; i++) {
            DkeCalloutInfo calloutInfo = this.f4609m.getCalloutInfo(i);
            C0931c c0931c = new C0931c(new PointF(calloutInfo.mTarget.mX, calloutInfo.mTarget.mY), new PointF(calloutInfo.mPosition.mX, calloutInfo.mPosition.mY), calloutInfo.mImageScale, (float) calloutInfo.mWidth, (float) calloutInfo.mMaxHeight);
            au auVar = new au();
            auVar.c = -1;
            az cbVar = new cb(this.f4608a, this.f4609m.getCalloutCaption(i), auVar);
            cbVar.m6409b(this.f4608a.f4524e.m6455j().f);
            c0931c.m6430b(cbVar);
            az cbVar2 = new cb(this.f4608a, this.f4609m.getCalloutTitle(i), new au());
            cbVar2.m6409b(this.f4608a.f4524e.m6455j().f);
            c0931c.m6428a(cbVar2);
            this.f4611o[i] = c0931c;
        }
    }
}
