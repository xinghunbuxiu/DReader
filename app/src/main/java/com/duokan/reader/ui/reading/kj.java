package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import com.duokan.core.app.AppContext;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ak;

public class kj extends gd implements to {
    /* renamed from: b */
    private float f10499b;
    /* renamed from: c */
    private int f10500c = 0;
    /* renamed from: d */
    private boolean f10501d = true;
    /* renamed from: e */
    private final Rect f10502e;
    /* renamed from: f */
    private final ad f10503f;
    /* renamed from: g */
    private final km f10504g;
    /* renamed from: h */
    private final su f10505h;
    /* renamed from: i */
    private boolean f10506i = false;
    /* renamed from: j */
    private boolean f10507j = true;
    /* renamed from: k */
    private final Runnable f10508k;

    public kj(Context context, ad adVar, Rect rect) {
        super(context);
        this.f10503f = adVar;
        this.f10508k = new kk(this);
        this.f10502e = rect;
        this.f10505h = (su) AppContext.getAppContext(getContext()).queryFeature(su.class);
        this.f10507j = this.f10505h.mo2106b(128);
        dv.m1921a((View) this, new kl(this));
        this.f10504g = new km(this, getContext());
        m14203a(this.f10504g, null);
        this.f10505h.mo2033a((to) this);
    }

    /* renamed from: i */
    public float mo2421i() {
        return this.f10499b;
    }

    /* renamed from: d */
    public void mo2334d() {
        super.mo2334d();
        this.f10506i = true;
    }

    /* renamed from: h */
    public void mo2414h() {
        super.mo2414h();
        this.f10506i = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10501d = false;
        this.f10505h.mo2102b((to) this);
        GifFrameLoader.m12418a().m12422a(this.f10503f);
    }

    /* renamed from: a */
    public void mo2199a(su suVar, ak akVar, ak akVar2) {
    }

    /* renamed from: a */
    public void mo2198a(su suVar, int i, int i2) {
        this.f10507j = suVar.mo2106b(128);
    }

    /* renamed from: l */
    private boolean m14548l() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof gx) {
                Object obj = (gx) parent;
                break;
            }
        }
        gx obj2 = null;
        if (obj2 == null) {
            return false;
        }
        if (this.f10505h.mo2007X() == obj2) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    private void m14549m() {
        if (this.f10501d) {
            if (this.f10507j && m14548l() && !this.f10505h.aW() && (!this.f10505h.bi() || this.f10506i)) {
                this.f10500c++;
                if (this.f10500c >= this.f10503f.mo1398a()) {
                    this.f10500c = 0;
                }
                GifFrameLoader.m12418a().m12423a(this.f10503f, this.f10500c, this.f10502e.width(), this.f10502e.height());
                this.f10504g.invalidate();
            }
            if (this.f10503f.mo1395j()) {
                UThread.postDelayed(this.f10508k, (long) Math.max(this.f10503f.mo1399a(this.f10500c), 20));
            }
        }
    }
}
