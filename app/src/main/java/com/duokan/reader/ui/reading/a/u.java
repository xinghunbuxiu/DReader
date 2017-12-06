package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.reader.ui.reading.DocPageLayout;
import com.duokan.reader.ui.reading.sh;

public class u extends er {
    private final sh a;
    private float c;
    private float d;
    private boolean e = false;
    private MotionEvent f;
    private int g;
    private long h = 0;
    private int i = 0;
    private int j = -1;
    private v k;

    public u(sh shVar, v vVar) {
        this.a = shVar;
        this.k = vVar;
    }

    public void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        if (this.a.M() == DocPageLayout.TOP_TO_BOTTOM || this.a.g() || !this.a.aa().A().isEmpty()) {
            b(false);
            return;
        }
        boolean z2;
        this.g = UTools.getScaledPagingTouchSlop(view.getContext()) * UTools.getScaledPagingTouchSlop(view.getContext());
        switch (motionEvent.getAction() & 255) {
            case 0:
                b(true);
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                this.i = 0;
                this.f = MotionEvent.obtain(motionEvent);
                this.h = System.currentTimeMillis();
                break;
            case 2:
                if (this.f == null) {
                    return;
                }
                if (this.i != 0 || System.currentTimeMillis() - this.h <= ((long) g())) {
                    this.i++;
                    float x = motionEvent.getX() - this.c;
                    float y = motionEvent.getY() - this.d;
                    int x2 = (int) (motionEvent.getX() - this.f.getX());
                    int y2 = (int) (motionEvent.getY() - this.f.getY());
                    if (((x2 * x2) + (y2 * y2) > this.g || this.e) && this.k != null) {
                        if (!this.e) {
                            if (UTools.addAnimation(new PointF(0.0f, 0.0f), new PointF((float) x2, (float) y2), 75.0d, 105.0d) && y2 > 0) {
                                if (this.j >= 0) {
                                    int i = this.j + 1;
                                    this.j = i;
                                    if (i > 1) {
                                        this.c = motionEvent.getX();
                                        this.d = motionEvent.getY();
                                        this.e = true;
                                        c(true);
                                        this.k.a(this.f, motionEvent);
                                        break;
                                    }
                                }
                                this.j++;
                                break;
                            }
                            b(false);
                            break;
                        }
                        this.k.a(this.f, motionEvent, x, y);
                        this.c = motionEvent.getX();
                        this.d = motionEvent.getY();
                        break;
                    }
                }
                b(false);
                return;
            break;
            default:
                if (!(this.k == null || !this.e || this.f == null)) {
                    this.k.b(this.f, motionEvent);
                    b(false);
                    break;
                }
        }
        if (motionEvent.getPointerCount() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        b(z2);
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        a(view, motionEvent, z, esVar);
    }

    public void a(View view, boolean z) {
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = false;
        this.i = 0;
        this.h = 0;
        this.j = -1;
        if (this.f != null) {
            this.f.recycle();
            this.f = null;
        }
    }
}
