package com.duokan.reader.ui.general;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class cv extends gj {
    final /* synthetic */ FixedPagesView a;

    protected cv(FixedPagesView fixedPagesView) {
        this.a = fixedPagesView;
        super(fixedPagesView);
    }

    public /* synthetic */ ge b() {
        return a();
    }

    public int a(int i) {
        if (this.a.j.length < 1) {
            return a().a(i);
        }
        RectF rectF = this.a.j[i % this.a.j.length];
        return (int) (((1.0f - rectF.left) - rectF.right) * ((float) a().a(i)));
    }

    public int b(int i) {
        if (this.a.j.length < 1) {
            return a().b(i);
        }
        RectF rectF = this.a.j[i % this.a.j.length];
        return (int) (((1.0f - rectF.top) - rectF.bottom) * ((float) a().b(i)));
    }

    public int c() {
        return this.c != null ? a().a() : 0;
    }

    public Object d(int i) {
        return null;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        cu cuVar = (cu) this.c.a(a().c(i), view, viewGroup);
        View d = cuVar.d();
        d.setLayoutParams(new LayoutParams(-1, -1));
        this.a.getCellsView().a(d, true);
        this.a.i[i] = cuVar;
        this.a.c((gi) cuVar);
        return d;
    }

    public void a_(int i, int i2) {
        a_(c());
    }

    public void b_(int i, int i2) {
        a_(c());
    }

    public void a(int i, int i2, int i3) {
        a_(c());
    }

    public void d(int i, int i2) {
        a_(c());
    }

    public void a_(int i) {
        this.a.i = new cu[c()];
        super.d();
    }

    public final cr a() {
        return (cr) super.b();
    }
}
