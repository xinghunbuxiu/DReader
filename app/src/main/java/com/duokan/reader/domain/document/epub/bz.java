package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.aw;

class bz extends bu implements aw {
    /* renamed from: a */
    final /* synthetic */ az f4620a;
    /* renamed from: m */
    private final int f4621m;
    /* renamed from: n */
    private final Rect f4622n;
    /* renamed from: o */
    private Bitmap f4623o;

    private bz(az azVar, DkeHitTestInfo dkeHitTestInfo, int i) {
        this.f4620a = azVar;
        super(azVar, dkeHitTestInfo);
        this.f4623o = null;
        this.f4621m = i;
        if (this.f4621m == 5) {
            this.f4622n = new Rect(mo1397l().right, 0, mo1396k().mo1402b(), mo1396k().mo1403c());
        } else {
            this.f4622n = new Rect(0, 0, mo1397l().left, mo1396k().mo1403c());
        }
    }

    /* renamed from: b */
    public void mo1417b() {
        super.mo1417b();
        if (this.f4623o != null) {
            this.f4623o.recycle();
            this.f4623o = null;
        }
    }

    /* renamed from: a */
    public Rect mo1418a() {
        return this.f4622n;
    }

    public boolean c_() {
        return this.f4621m == 5;
    }

    /* renamed from: c */
    public boolean mo1419c() {
        return this.f4621m == 6;
    }

    /* renamed from: d */
    public Bitmap mo1421d() {
        m6763m();
        return this.f4623o;
    }

    /* renamed from: m */
    private void m6763m() {
        if (this.f4623o == null) {
            this.f4623o = C0544a.m2447c(this.g.f4599c, this.g.f4600d, Config.RGB_565);
            this.f4623o.eraseColor(-1);
            DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
            this.f4620a.m6547a(dkFlowRenderOption, this.f4623o, this.f4620a.f4526g);
            this.f4620a.m6544Y().renderImage(this.g.f4598b, dkFlowRenderOption, new DkBox(0.0f, 0.0f, (float) this.g.f4599c, (float) this.g.f4600d), new DkBox(0.0f, 0.0f, (float) this.g.f4599c, (float) this.g.f4600d), this.g.f4599c, this.g.f4600d);
        }
    }
}
