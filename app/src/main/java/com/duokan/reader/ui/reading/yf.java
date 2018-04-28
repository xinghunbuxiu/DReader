package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.sbk.C0979t;

public class yf extends gx {
    /* renamed from: y */
    private final su f11187y = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));

    public yf(Context context, hd hdVar) {
        super(context, hdVar);
    }

    public void setPage(gs gsVar) {
        View view;
        super.setPage(gsVar);
        if (gsVar == null || !(gsVar.mo2327c() instanceof yi)) {
            view = null;
        } else {
            view = ((yi) gsVar.mo2327c()).m15165b();
        }
        if (view != null) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        if (!(view == null || view.getParent() == null)) {
            ((gt) view.getParent()).setCustomView(null);
        }
        this.b.setCustomView(view);
    }

    /* renamed from: a */
    public boolean mo2389a() {
        return m15145k() != null;
    }

    /* renamed from: b */
    public void mo2390b() {
        if (m15145k() != null) {
            this.f11187y.bl().m12756a(m15145k());
        }
    }

    /* renamed from: a */
    protected gt mo2387a(Context context) {
        return new bn(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !(this.j.mo2327c() instanceof yi) && this.k.mo1284G() && this.k.isVisible()) {
            if ((!this.k.mo1456D().isEmpty() || this.k.m6151i() == 2) && !((ba) this.k).mo1299a()) {
                C0979t c0979t = (C0979t) this.k.mo1332l();
                Paint paint = (Paint) dv.f1193b.addAnimation();
                paint.setColor(this.k.mo1342q().f4355c);
                paint.setTextSize((float) (this.k.mo1340p().f4330a / 5));
                dv.m1913a(canvas, "" + (c0979t.mo1454j().m7142h() + 1), this.k.getBounds(), 17, paint);
                dv.f1193b.clearAnimation(paint);
            }
        }
    }

    /* renamed from: a */
    protected void mo2515a(Canvas canvas, boolean z) {
        if (this.j != null) {
            if (!(this.j.mo2327c() instanceof yi)) {
                super.mo2515a(canvas, z);
            } else if (this.j.mo2332h().mo1340p().f4334e) {
                Paint paint = (Paint) dv.f1193b.addAnimation();
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), paint);
                dv.f1193b.clearAnimation(paint);
            }
        }
    }

    /* renamed from: k */
    private View m15145k() {
        if (getPage().mo2327c() instanceof yi) {
            return this.b.getCustomView();
        }
        return null;
    }
}
