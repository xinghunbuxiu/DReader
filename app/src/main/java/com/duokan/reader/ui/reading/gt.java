package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.document.as;
import java.util.LinkedList;
import org.apache.http.HttpStatus;

public class gt extends FrameLayout {
    /* renamed from: a */
    protected static final LinkedList<gt> f9863a = new LinkedList();
    /* renamed from: b */
    protected final su f9864b = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));
    /* renamed from: c */
    protected as f9865c = null;
    /* renamed from: d */
    protected int f9866d = 0;
    /* renamed from: e */
    private View f9867e = null;
    /* renamed from: f */
    private View f9868f = null;

    public gt(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void m13803a(as asVar) {
        if (this.f9865c != asVar) {
            this.f9865c = asVar;
            m13802a(0);
        }
        m13802a(mo2282b());
    }

    public final View getCustomView() {
        return this.f9868f;
    }

    public final void setCustomView(View view) {
        if (this.f9868f != view) {
            if (this.f9868f != null) {
                removeView(this.f9868f);
                this.f9868f = null;
            }
            this.f9868f = view;
            if (this.f9868f != null) {
                addView(this.f9868f, new LayoutParams(-1, -1));
            }
        }
    }

    /* renamed from: k */
    public final boolean m13808k() {
        if (getVisibility() != 0 || this.f9865c == null || !this.f9865c.mo1284G()) {
            return true;
        }
        if (this.f9865c.mo1332l().m5817f()) {
            return false;
        }
        if (this.f9868f != null) {
            return false;
        }
        return true;
    }

    /* renamed from: l */
    public final void m13809l() {
        mo2281a();
    }

    /* renamed from: a */
    protected final void m13802a(int i) {
        if (this.f9866d != i) {
            this.f9866d = i;
            mo2281a();
        }
    }

    /* renamed from: a */
    protected void mo2281a() {
        switch (this.f9866d) {
            case 0:
                m13810m();
                return;
            case 1:
            case 3:
            case 5:
                mo2283c();
                return;
            default:
                m13810m();
                return;
        }
    }

    /* renamed from: b */
    protected int mo2282b() {
        if (this.f9868f != null) {
            return 5;
        }
        if (this.f9865c == null) {
            return 0;
        }
        if (!this.f9865c.isVisible()) {
            return 1;
        }
        if (!this.f9865c.mo1284G()) {
            return 2;
        }
        if (this.f9865c.mo1330k() && this.f9865c.m6151i() != 1) {
            return 2;
        }
        if (this.f9865c.mo1332l().m5817f()) {
            return 4;
        }
        return 3;
    }

    /* renamed from: m */
    protected void m13810m() {
        mo2283c();
        if (this.f9867e == null) {
            this.f9867e = new FrameLayout(getContext());
            this.f9867e.setBackgroundDrawable(new gr(getContext()));
            addView(this.f9867e, new LayoutParams(-1, -1));
        }
        this.f9867e.setVisibility(0);
        this.f9867e.invalidate();
    }

    /* renamed from: c */
    protected void mo2283c() {
        if (this.f9867e != null) {
            this.f9867e.setVisibility(4);
        }
    }

    /* renamed from: n */
    protected int m13811n() {
        return this.f9864b.mo2001R();
    }

    /* renamed from: o */
    protected int m13812o() {
        if (this.f9864b.aI() || this.f9864b.aJ()) {
            return this.f9864b.mo2000Q();
        }
        return Color.rgb(51, 51, 51);
    }

    /* renamed from: p */
    protected int m13813p() {
        if (this.f9864b.aI() || this.f9864b.aJ()) {
            return this.f9864b.mo2000Q();
        }
        return Color.rgb(HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f9863a.add(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f9863a.remove(this);
    }

    /* renamed from: d */
    public void mo2284d() {
    }

    /* renamed from: e */
    public void mo2285e() {
    }
}
