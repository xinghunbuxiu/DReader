package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.x;
import com.duokan.reader.domain.document.as;

import org.apache.http.HttpStatus;

import java.util.LinkedList;

public class go extends FrameLayout {
    protected static final LinkedList a = new LinkedList();
    protected final sh b = ((sh) x.a(getContext()).queryFeature(sh.class));
    protected as c = null;
    protected int d = 0;
    private View e = null;
    private View f = null;

    public go(Context context) {
        super(context);
    }

    public final void a(as asVar) {
        if (this.c != asVar) {
            this.c = asVar;
            a(0);
        }
        a(b());
    }

    public final View getCustomView() {
        return this.f;
    }

    public final void setCustomView(View view) {
        if (this.f != view) {
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            this.f = view;
            if (this.f != null) {
                addView(this.f, new LayoutParams(-1, -1));
            }
        }
    }

    public final void k() {
        a();
    }

    protected final void a(int i) {
        if (this.d != i) {
            this.d = i;
            a();
        }
    }

    protected void a() {
        switch (this.d) {
            case 0:
                l();
                return;
            case 1:
            case 3:
            case 5:
                c();
                return;
            default:
                l();
                return;
        }
    }

    protected int b() {
        if (this.f != null) {
            return 5;
        }
        if (this.c == null) {
            return 0;
        }
        if (!this.c.isVisible()) {
            return 1;
        }
        if (!this.c.G()) {
            return 2;
        }
        if (this.c.k() && this.c.i() != 1) {
            return 2;
        }
        if (this.c.l().f()) {
            return 4;
        }
        return 3;
    }

    protected void l() {
        c();
        if (this.e == null) {
            this.e = new FrameLayout(getContext());
            this.e.setBackgroundDrawable(new gm(getContext()));
            addView(this.e, new LayoutParams(-1, -1));
        }
        this.e.setVisibility(0);
        this.e.invalidate();
    }

    protected void c() {
        if (this.e != null) {
            this.e.setVisibility(4);
        }
    }

    protected int m() {
        return this.b.R();
    }

    protected int n() {
        if (this.b.aI() || this.b.aJ()) {
            return this.b.Q();
        }
        return Color.rgb(51, 51, 51);
    }

    protected int o() {
        if (this.b.aI() || this.b.aJ()) {
            return this.b.Q();
        }
        return Color.rgb(HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.add(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.remove(this);
    }

    public void d() {
    }

    public void e() {
    }
}
