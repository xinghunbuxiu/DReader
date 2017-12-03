package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.sbk.t;

public class xs extends gs {
    private final sh y = ((sh) x.a(getContext()).queryFeature(sh.class));

    public xs(Context context, gy gyVar) {
        super(context, gyVar);
    }

    public void setPage(gn gnVar) {
        View view;
        super.setPage(gnVar);
        if (gnVar == null || !(gnVar.c() instanceof xv)) {
            view = null;
        } else {
            view = ((xv) gnVar.c()).b();
        }
        if (view != null) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        if (!(view == null || view.getParent() == null)) {
            ((go) view.getParent()).setCustomView(null);
        }
        this.b.setCustomView(view);
    }

    public boolean a() {
        return k() != null;
    }

    public void b() {
        if (k() != null) {
            this.y.bk().a(k());
        }
    }

    protected go a(Context context) {
        return new bn(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !(this.j.c() instanceof xv) && this.k.G() && this.k.isVisible()) {
            if ((!this.k.D().isEmpty() || this.k.i() == 2) && !((ba) this.k).a()) {
                t tVar = (t) this.k.l();
                Paint paint = (Paint) UTools.b.getRect();
                paint.setColor(this.k.q().c);
                paint.setTextSize((float) (this.k.p().a / 5));
                UTools.addAnimation(canvas, "" + (tVar.j().h() + 1), this.k.getBounds(), 17, paint);
                UTools.b.getRect(paint);
            }
        }
    }

    protected void a(Canvas canvas, boolean z) {
        if (this.j != null) {
            if (!(this.j.c() instanceof xv)) {
                super.a(canvas, z);
            } else if (this.j.h().p().e) {
                Paint paint = (Paint) UTools.b.getRect();
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), paint);
                UTools.b.getRect(paint);
            }
        }
    }

    private View k() {
        if (getPage().c() instanceof xv) {
            return this.b.getCustomView();
        }
        return null;
    }
}
