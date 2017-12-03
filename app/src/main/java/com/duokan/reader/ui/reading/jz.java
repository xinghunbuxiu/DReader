package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ak;

public class jz extends fy implements tb {
    private float b;
    private int c = 0;
    private boolean d = true;
    private final Rect e;
    private final ad f;
    private final kc g;
    private final sh h;
    private boolean i = false;
    private boolean j = true;
    private final Runnable k;

    public jz(Context context, ad adVar, Rect rect) {
        super(context);
        this.f = adVar;
        this.k = new ka(this);
        this.e = rect;
        this.h = (sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class);
        this.j = this.h.b(128);
        UTools.addAnimation((View) this, new kb(this));
        this.g = new kc(this, getContext());
        a(this.g, null);
        this.h.a((tb) this);
    }

    public float i() {
        return this.b;
    }

    public void d() {
        super.d();
        this.i = true;
    }

    public void h() {
        super.h();
        this.i = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = false;
        this.h.b((tb) this);
        GifFrameLoader.a().a(this.f);
    }

    public void a(sh shVar, ak akVar, ak akVar2) {
    }

    public void a(sh shVar, int i, int i2) {
        this.j = shVar.b(128);
    }

    private boolean l() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof gs) {
                Object obj = (gs) parent;
                break;
            }
        }
        gs gsVar = null;
        if (obj == null) {
            return false;
        }
        if (this.h.X() == obj) {
            return true;
        }
        return false;
    }

    private void m() {
        if (this.d) {
            if (this.j && l() && !this.h.aW() && (!this.h.bh() || this.i)) {
                this.c++;
                if (this.c >= this.f.a()) {
                    this.c = 0;
                }
                GifFrameLoader.a().a(this.f, this.c, this.e.width(), this.e.height());
                this.g.invalidate();
            }
            if (this.f.j()) {
                TaskHandler.postDelayed(this.k, (long) Math.max(this.f.a(this.c), 20));
            }
        }
    }
}
