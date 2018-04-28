package com.duokan.reader.ui.general;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class cv extends gd {
    /* renamed from: a */
    final /* synthetic */ FixedPagesView f7051a;

    protected cv(FixedPagesView fixedPagesView) {
        this.f7051a = fixedPagesView;
        super(fixedPagesView);
    }

    /* renamed from: b */
    public /* synthetic */ fy mo1765b() {
        return m10415a();
    }

    /* renamed from: a */
    public int m10414a(int i) {
        if (this.f7051a.f6845j.length < 1) {
            return m10415a().mo2317a(i);
        }
        RectF rectF = this.f7051a.f6845j[i % this.f7051a.f6845j.length];
        return (int) (((1.0f - rectF.left) - rectF.right) * ((float) m10415a().mo2317a(i)));
    }

    /* renamed from: b */
    public int m10417b(int i) {
        if (this.f7051a.f6845j.length < 1) {
            return m10415a().mo2321b(i);
        }
        RectF rectF = this.f7051a.f6845j[i % this.f7051a.f6845j.length];
        return (int) (((1.0f - rectF.top) - rectF.bottom) * ((float) m10415a().mo2321b(i)));
    }

    /* renamed from: c */
    public int mo506c() {
        return this.c != null ? m10415a().mo2316a() : 0;
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return null;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        cu cuVar = (cu) this.c.mo2319a(m10415a().mo2323c(i), view, viewGroup);
        View d = cuVar.mo2328d();
        d.setLayoutParams(new LayoutParams(-1, -1));
        this.f7051a.getCellsView().mo435a(d, true);
        this.f7051a.f6844i[i] = cuVar;
        this.f7051a.m10012c((gc) cuVar);
        return d;
    }

    public void a_(int i, int i2) {
        a_(mo506c());
    }

    public void b_(int i, int i2) {
        a_(mo506c());
    }

    /* renamed from: a */
    public void mo440a(int i, int i2, int i3) {
        a_(mo506c());
    }

    /* renamed from: d */
    public void mo444d(int i, int i2) {
        a_(mo506c());
    }

    public void a_(int i) {
        this.f7051a.f6844i = new cu[mo506c()];
        super.mo1691d();
    }

    /* renamed from: a */
    public final cr m10415a() {
        return (cr) super.mo1765b();
    }
}
