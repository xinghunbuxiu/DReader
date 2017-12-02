package com.duokan.reader.ui.reading;

import android.graphics.RectF;

class iq implements ja {
    final /* synthetic */ is a;
    final /* synthetic */ ip b;

    iq(ip ipVar, is isVar) {
        this.b = ipVar;
        this.a = isVar;
    }

    public void a() {
        this.b.requestBack();
    }

    public void b() {
        this.b.requestBack();
        this.a.a();
    }

    public void a(RectF rectF, boolean z) {
        this.b.requestBack();
        RectF[] rectFArr = new RectF[2];
        rectFArr[0] = rectF;
        if (!z) {
            rectF = new RectF(rectF.right, rectF.top, rectF.left, rectF.bottom);
        }
        rectFArr[1] = rectF;
        this.a.a(rectFArr);
    }
}
