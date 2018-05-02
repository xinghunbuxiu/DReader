package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.epublib.DkeFlexPage;
import com.duokan.reader.domain.document.az;

class cb extends az {
    final /* synthetic */ az a;
    private final au b;
    private final DkeFlexPage c;
    private final DkFlowRenderOption d = new DkFlowRenderOption();

    protected cb(az azVar, DkeFlexPage dkeFlexPage, au auVar) {
        this.a = azVar;
        this.b = auVar;
        this.c = dkeFlexPage;
        c(0);
    }

    protected void i() {
        this.c.setPageWidth((double) a());
        this.c.setLineGap((double) d());
        this.c.setParaSpacing((double) e());
        this.c.setTabStop((double) f());
        this.c.setFirstLineIndent((double) g());
        this.c.setFontSize((double) h());
        this.c.measureSize();
        a((int) Math.ceil(this.c.getLayoutWidth()), (int) Math.ceil(this.c.getLayoutHeight()));
    }

    protected void j() {
        this.c.calcPageLayout();
    }

    protected void b(Bitmap bitmap, Rect rect) {
        DkPos dkPos = new DkPos();
        dkPos.mX = 0.0f;
        dkPos.mY = 0.0f;
        this.c.setPageTopLeft(dkPos);
        DkBox dkBox = new DkBox();
        dkBox.mX0 = (float) rect.left;
        dkBox.mY0 = (float) rect.top;
        dkBox.mX1 = (float) rect.right;
        dkBox.mY1 = (float) rect.bottom;
        if (this.b == null) {
            this.a.a(this.d, bitmap, this.a.g);
        } else {
            this.a.a(this.d, bitmap, this.b);
        }
        this.c.renderArea(this.d, dkBox);
        this.d.mBitmap = null;
    }
}
