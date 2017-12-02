package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.domain.document.aw;

class bz extends bu implements aw {
    final /* synthetic */ az a;
    private final int m;
    private final Rect n;
    private Bitmap o;

    private bz(az azVar, DkeHitTestInfo dkeHitTestInfo, int i) {
        this.a = azVar;
        super(azVar, dkeHitTestInfo);
        this.o = null;
        this.m = i;
        if (this.m == 5) {
            this.n = new Rect(l().right, 0, k().b(), k().c());
        } else {
            this.n = new Rect(0, 0, l().left, k().c());
        }
    }

    public void b() {
        super.b();
        if (this.o != null) {
            this.o.recycle();
            this.o = null;
        }
    }

    public Rect a() {
        return this.n;
    }

    public boolean b_() {
        return this.m == 5;
    }

    public boolean c() {
        return this.m == 6;
    }

    public Bitmap d() {
        m();
        return this.o;
    }

    private void m() {
        if (this.o == null) {
            this.o = a.c(this.g.c, this.g.d, Config.RGB_565);
            this.o.eraseColor(-1);
            DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
            this.a.a(dkFlowRenderOption, this.o, this.a.g);
            this.a.Z().renderImage(this.g.b, dkFlowRenderOption, new DkBox(0.0f, 0.0f, (float) this.g.c, (float) this.g.d), new DkBox(0.0f, 0.0f, (float) this.g.c, (float) this.g.d), this.g.c, this.g.d);
        }
    }
}
