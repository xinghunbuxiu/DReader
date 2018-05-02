package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class as extends er {
    private MotionEvent a = null;
    private MotionEvent c = null;
    private int d = ((int) (((float) UTools.getLongPressTimeout()) * 1.5f));
    private int e = 0;
    private int f = this.d;
    private at g = null;
    private boolean h = false;

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.f = i;
    }

    protected void a(View view, boolean z) {
        if (this.a != null) {
            this.a.recycle();
            this.a = null;
        }
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
        this.g = null;
        this.h = false;
        this.e = 0;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        if (esVar instanceof au) {
            au auVar = (au) esVar;
            if (motionEvent.getPointerCount() > 1) {
                b(false);
                this.g = null;
                return;
            } else if (this.a == null) {
                this.a = MotionEvent.obtainNoHistory(motionEvent);
                this.g = new at(this, view);
                view.postDelayed(this.g, (long) this.d);
                return;
            } else {
                if (this.c != null) {
                    this.c.recycle();
                    this.c = null;
                }
                this.c = MotionEvent.obtainNoHistory(motionEvent);
                if (d(new PointF(this.a.getRawX(), this.a.getRawY()), new PointF(this.c.getRawX(), this.c.getRawY())) > ((double) b(view))) {
                    this.e = 0;
                    this.a = this.c;
                    this.c = null;
                    this.g = new at(this, view);
                    view.postDelayed(this.g, (long) this.d);
                    return;
                } else if (this.h) {
                    PointF pointF = new PointF(this.c.getX(0), this.c.getY(0));
                    int i = this.e;
                    this.e = i + 1;
                    auVar.a(view, pointF, i);
                    this.a = this.c;
                    this.c = null;
                    this.g = new at(this, view);
                    view.postDelayed(this.g, (long) this.f);
                    return;
                } else {
                    return;
                }
            }
        }
        b(false);
        this.g = null;
    }
}
