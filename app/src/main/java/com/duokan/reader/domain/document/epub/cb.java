package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.epublib.DkeFlexPage;
import com.duokan.reader.domain.document.az;

class cb extends az {
    /* renamed from: a */
    final /* synthetic */ az f4640a;
    /* renamed from: b */
    private final au f4641b;
    /* renamed from: c */
    private final DkeFlexPage f4642c;
    /* renamed from: d */
    private final DkFlowRenderOption f4643d = new DkFlowRenderOption();

    protected cb(az azVar, DkeFlexPage dkeFlexPage, au auVar) {
        this.f4640a = azVar;
        this.f4641b = auVar;
        this.f4642c = dkeFlexPage;
        m6413c(0);
    }

    /* renamed from: i */
    protected void mo1425i() {
        this.f4642c.setPageWidth((double) m6402a());
        this.f4642c.setLineGap((double) m6414d());
        this.f4642c.setParaSpacing((double) m6416e());
        this.f4642c.setTabStop((double) m6417f());
        this.f4642c.setFirstLineIndent((double) m6418g());
        this.f4642c.setFontSize((double) m6419h());
        this.f4642c.measureSize();
        m6405a((int) Math.ceil(this.f4642c.getLayoutWidth()), (int) Math.ceil(this.f4642c.getLayoutHeight()));
    }

    /* renamed from: j */
    protected void mo1426j() {
        this.f4642c.calcPageLayout();
    }

    /* renamed from: b */
    protected void mo1424b(Bitmap bitmap, Rect rect) {
        DkPos dkPos = new DkPos();
        dkPos.mX = 0.0f;
        dkPos.mY = 0.0f;
        this.f4642c.setPageTopLeft(dkPos);
        DkBox dkBox = new DkBox();
        dkBox.mX0 = (float) rect.left;
        dkBox.mY0 = (float) rect.top;
        dkBox.mX1 = (float) rect.right;
        dkBox.mY1 = (float) rect.bottom;
        if (this.f4641b == null) {
            this.f4640a.m6547a(this.f4643d, bitmap, this.f4640a.f4526g);
        } else {
            this.f4640a.m6547a(this.f4643d, bitmap, this.f4641b);
        }
        this.f4642c.renderArea(this.f4643d, dkBox);
        this.f4643d.mBitmap = null;
    }
}
