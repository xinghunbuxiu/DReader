package com.duokan.reader.domain.document.epub;

import android.graphics.PointF;
import android.graphics.Rect;

import com.duokan.kernel.epublib.DkeCalloutInfo;
import com.duokan.kernel.epublib.DkeMultiCallout;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.az;
import com.duokan.reader.domain.document.c;

class bt extends bu implements aj {
    final /* synthetic */ az a;
    private final DkeMultiCallout m;
    private final Rect n;
    private final c[] o;

    private bt(az azVar, DkeMultiCallout dkeMultiCallout) {
        this.a = azVar;
        super(azVar, dkeMultiCallout.getBaseImageInfo());
        this.m = dkeMultiCallout;
        this.o = new c[this.m.getCalloutCount()];
        this.n = this.m.getBaseImageInfo().mBoundingBox.toRect();
        d();
    }

    public void b() {
        this.m.recycle();
        super.b();
    }

    public c a(int i) {
        return this.o[i];
    }

    public int a() {
        return this.o.length;
    }

    public Rect c() {
        return this.m.getNavigationBox().toRect();
    }

    private void d() {
        for (int i = 0; i < this.o.length; i++) {
            DkeCalloutInfo calloutInfo = this.m.getCalloutInfo(i);
            c cVar = new c(new PointF(calloutInfo.mTarget.mX, calloutInfo.mTarget.mY), new PointF(calloutInfo.mPosition.mX, calloutInfo.mPosition.mY), calloutInfo.mImageScale, (float) calloutInfo.mWidth, (float) calloutInfo.mMaxHeight);
            au auVar = new au();
            auVar.c = -1;
            az cbVar = new cb(this.a, this.m.getCalloutCaption(i), auVar);
            cbVar.b(this.a.e.j().f);
            cVar.b(cbVar);
            az cbVar2 = new cb(this.a, this.m.getCalloutTitle(i), new au());
            cbVar2.b(this.a.e.j().f);
            cVar.a(cbVar2);
            this.o[i] = cVar;
        }
    }
}
