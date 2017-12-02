package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.app.m;
import com.duokan.core.app.x;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;
import com.duokan.reader.DkApp;

public class gi extends lb {
    private boolean b = false;
    private final sh c;
    private final tb d = i();

    public gi(Context context) {
        super(context);
        this.c = (sh) x.a(context).queryFeature(sh.class);
        setClipChildren(false);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.a(this.d);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.b(this.d);
    }

    protected void b() {
        super.b();
        this.b = true;
        View activeImageView = getActiveImageView();
        this.c.a(32, 0);
        this.c.aQ();
        ((m) DkApp.get().getTopActivity()).lockCurrentOrientation();
        activeImageView.setLayoutParams(new dn(-1, -1, 17, 0, h().y - (getHeight() / 2)));
        a(activeImageView, new dl());
    }

    protected void c() {
        if (this.b) {
            this.b = false;
            fu activeImageView = getActiveImageView();
            Rect originBounds = activeImageView.getOriginBounds();
            activeImageView.setLayoutParams(new dn(originBounds.width(), originBounds.height(), 51));
            a((View) activeImageView, a(activeImageView));
            this.c.aR();
            ((m) DkApp.get().getTopActivity()).unlockCurrentOrientation();
        }
        super.c();
    }

    protected dl a(fu fuVar) {
        Rect originBounds = getActiveImageView().getOriginBounds();
        dl a = super.a(fuVar);
        if (!this.b) {
            return a;
        }
        Point h = h();
        float max = Math.max((((float) originBounds.width()) * 1.0f) / ((float) getWidth()), (((float) originBounds.height()) * 1.0f) / ((float) getHeight()));
        return new dl(1.0f, originBounds.centerX() - h.x, originBounds.centerY() - h.y, a.l(), a.m() * max, a.m() * max);
    }

    protected void d() {
        this.c.a(0, 32);
    }

    protected void b(fu fuVar) {
        this.c.a(fuVar.getImage(), fuVar.getOriginBounds());
    }

    private tb i() {
        return new gj(this);
    }
}
