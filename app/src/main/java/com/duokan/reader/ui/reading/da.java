package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0383g;
import com.duokan.core.ui.C0392q;
import com.duokan.core.ui.cd;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

public class da extends er {
    /* renamed from: a */
    final /* synthetic */ cq f9975a;
    /* renamed from: c */
    private final cd f9976c = new cd();
    /* renamed from: d */
    private final C0392q f9977d = new C0392q();
    /* renamed from: e */
    private final dt f9978e = new dt();
    /* renamed from: f */
    private final C0383g f9979f = new C0383g(1);
    /* renamed from: g */
    private final C0383g f9980g = new C0383g(2);
    /* renamed from: h */
    private final Rect f9981h = new Rect();
    /* renamed from: i */
    private boolean f9982i = false;
    /* renamed from: j */
    private boolean f9983j = false;

    public da(cq cqVar) {
        this.f9975a = cqVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        boolean z2 = true;
        cd cdVar = this.f9976c;
        boolean z3 = z || !this.f9976c.m1618c();
        cdVar.m1612b(view, z3);
        this.f9976c.m1756a(0.01f);
        this.f9976c.m1757a(AnimUtils.getScaledPagingTouchSlop(view.getContext()));
        C0392q c0392q = this.f9977d;
        if (z || !this.f9977d.m1618c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        c0392q.m1612b(view, z3);
        this.f9977d.m2168a((float) m1603a(view, 30));
        dt dtVar = this.f9978e;
        if (z || !this.f9978e.m1618c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        dtVar.m1612b(view, z3);
        this.f9978e.m1882a(m1610b(view));
        C0383g c0383g = this.f9979f;
        if (z || !this.f9979f.m1618c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        c0383g.m1612b(view, z3);
        C0383g c0383g2 = this.f9980g;
        if (!z && this.f9980g.m1618c()) {
            z2 = false;
        }
        c0383g2.m1612b(view, z2);
        this.f9982i = false;
        this.f9983j = false;
        DisplayMetrics displayMetrics = this.f9975a.getResources().getDisplayMetrics();
        this.f9981h.set(displayMetrics.widthPixels / 4, displayMetrics.heightPixels / 4, view.getRight() - (displayMetrics.widthPixels / 4), view.getBottom() - (displayMetrics.heightPixels / 4));
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (this.f9975a.f9949a.mo2181w().mo2295f()) {
            if (motionEvent.getAction() == 0 && Float.compare(this.f9975a.f9952d.getFrameScale(), 1.0f) >= 0) {
                this.f9975a.f9952d.m13306a(0, 0, false);
            }
            if (m1618c() && !m1623e() && this.f9976c.m1618c()) {
                this.f9976c.m1611b(view, motionEvent, z, new db(this));
            }
            if (m1618c() && !m1623e() && this.f9978e.m1618c()) {
                this.f9978e.m1611b(view, motionEvent, z, new dc(this, motionEvent));
            }
            if (m1618c() && !m1623e() && this.f9977d.m1618c()) {
                this.f9977d.m1611b(view, motionEvent, z, new dd(this));
            }
            if (m1618c() && !m1623e() && this.f9979f.m1618c()) {
                this.f9979f.m1611b(view, motionEvent, z, new de(this));
            }
            if (m1618c() && !m1623e() && this.f9980g.m1618c()) {
                this.f9980g.m1611b(view, motionEvent, z, new df(this));
            }
            if (motionEvent.getAction() == 1) {
                if (Float.compare(this.f9975a.f9952d.getFrameScale(), 1.0f) < 0) {
                    this.f9975a.f9952d.m13308a(new Point(this.f9975a.f9952d.getWidth() / 2, this.f9975a.f9952d.getHeight() / 2), 1.0f, true);
                } else if (this.f9982i) {
                    this.f9975a.f9952d.m13304a();
                }
            }
            m1622e(this.f9980g.m1624f());
            if (!(m1618c() && (this.f9976c.m1618c() || this.f9977d.m1618c() || this.f9979f.m1618c() || this.f9980g.m1618c()))) {
                z2 = false;
            }
            m1613b(z2);
        }
    }
}
