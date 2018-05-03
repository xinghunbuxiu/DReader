package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class as extends er {
    /* renamed from: a */
    private MotionEvent f978a = null;
    /* renamed from: c */
    private MotionEvent f979c = null;
    /* renamed from: d */
    private int f980d = ((int) (((float) AnimUtils.getLongPressTimeout()) * 1.5f));
    /* renamed from: e */
    private int f981e = 0;
    /* renamed from: f */
    private int f982f = this.f980d;
    /* renamed from: g */
    private at f983g = null;
    /* renamed from: h */
    private boolean f984h = false;

    /* renamed from: a */
    public int m1631a() {
        return this.f980d;
    }

    /* renamed from: a */
    public void m1632a(int i) {
        this.f980d = i;
    }

    /* renamed from: b */
    public void m1635b(int i) {
        this.f982f = i;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        if (this.f978a != null) {
            this.f978a.recycle();
            this.f978a = null;
        }
        if (this.f979c != null) {
            this.f979c.recycle();
            this.f979c = null;
        }
        this.f983g = null;
        this.f984h = false;
        this.f981e = 0;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof au) {
            au auVar = (au) esVar;
            if (motionEvent.getPointerCount() > 1) {
                m1613b(false);
                this.f983g = null;
                return;
            } else if (this.f978a == null) {
                this.f978a = MotionEvent.obtainNoHistory(motionEvent);
                this.f983g = new at(this, view);
                view.postDelayed(this.f983g, (long) this.f980d);
                return;
            } else {
                if (this.f979c != null) {
                    this.f979c.recycle();
                    this.f979c = null;
                }
                this.f979c = MotionEvent.obtainNoHistory(motionEvent);
                if (m1619d(new PointF(this.f978a.getRawX(), this.f978a.getRawY()), new PointF(this.f979c.getRawX(), this.f979c.getRawY())) > ((double) m1610b(view))) {
                    this.f981e = 0;
                    this.f978a = this.f979c;
                    this.f979c = null;
                    this.f983g = new at(this, view);
                    view.postDelayed(this.f983g, (long) this.f980d);
                    return;
                } else if (this.f984h) {
                    PointF pointF = new PointF(this.f979c.getX(0), this.f979c.getY(0));
                    int i = this.f981e;
                    this.f981e = i + 1;
                    auVar.mo1681a(view, pointF, i);
                    this.f978a = this.f979c;
                    this.f979c = null;
                    this.f983g = new at(this, view);
                    view.postDelayed(this.f983g, (long) this.f982f);
                    return;
                } else {
                    return;
                }
            }
        }
        m1613b(false);
        this.f983g = null;
    }
}
