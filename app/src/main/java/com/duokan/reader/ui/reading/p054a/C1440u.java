package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.DocPageLayout;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.u */
public class C1440u extends er {
    /* renamed from: a */
    private final su f9237a;
    /* renamed from: c */
    private float f9238c;
    /* renamed from: d */
    private float f9239d;
    /* renamed from: e */
    private boolean f9240e = false;
    /* renamed from: f */
    private MotionEvent f9241f;
    /* renamed from: g */
    private int f9242g;
    /* renamed from: h */
    private long f9243h = 0;
    /* renamed from: i */
    private int f9244i = 0;
    /* renamed from: j */
    private int f9245j = -1;
    /* renamed from: k */
    private C1441v f9246k;

    public C1440u(su suVar, C1441v c1441v) {
        this.f9237a = suVar;
        this.f9246k = c1441v;
    }

    /* renamed from: a */
    public void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f9237a.mo1996M() == DocPageLayout.TOP_TO_BOTTOM || this.f9237a.mo2145g() || !this.f9237a.aa().mo1280A().isEmpty()) {
            m1613b(false);
            return;
        }
        boolean z2;
        this.f9242g = AnimUtils.getScaledPagingTouchSlop(view.getContext()) * AnimUtils.getScaledPagingTouchSlop(view.getContext());
        switch (motionEvent.getAction() & 255) {
            case 0:
                m1613b(true);
                this.f9238c = motionEvent.getX();
                this.f9239d = motionEvent.getY();
                this.f9244i = 0;
                this.f9241f = MotionEvent.obtain(motionEvent);
                this.f9243h = System.currentTimeMillis();
                break;
            case 2:
                if (this.f9241f == null) {
                    return;
                }
                if (this.f9244i != 0 || System.currentTimeMillis() - this.f9243h <= ((long) m1625g())) {
                    this.f9244i++;
                    float x = motionEvent.getX() - this.f9238c;
                    float y = motionEvent.getY() - this.f9239d;
                    int x2 = (int) (motionEvent.getX() - this.f9241f.getX());
                    int y2 = (int) (motionEvent.getY() - this.f9241f.getY());
                    if (((x2 * x2) + (y2 * y2) > this.f9242g || this.f9240e) && this.f9246k != null) {
                        if (!this.f9240e) {
                            if (AnimUtils.m1924a(new PointF(0.0f, 0.0f), new PointF((float) x2, (float) y2), 75.0d, 105.0d) && y2 > 0) {
                                if (this.f9245j >= 0) {
                                    int i = this.f9245j + 1;
                                    this.f9245j = i;
                                    if (i > 1) {
                                        this.f9238c = motionEvent.getX();
                                        this.f9239d = motionEvent.getY();
                                        this.f9240e = true;
                                        m1617c(true);
                                        this.f9246k.mo2278a(this.f9241f, motionEvent);
                                        break;
                                    }
                                }
                                this.f9245j++;
                                break;
                            }
                            m1613b(false);
                            break;
                        }
                        this.f9246k.mo2279a(this.f9241f, motionEvent, x, y);
                        this.f9238c = motionEvent.getX();
                        this.f9239d = motionEvent.getY();
                        break;
                    }
                }
                m1613b(false);
                return;
                break;
            default:
                if (!(this.f9246k == null || !this.f9240e || this.f9241f == null)) {
                    this.f9246k.mo2280b(this.f9241f, motionEvent);
                    m1613b(false);
                    break;
                }
        }
        if (motionEvent.getPointerCount() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        m1613b(z2);
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    public void mo511a(View view, boolean z) {
        this.f9238c = 0.0f;
        this.f9239d = 0.0f;
        this.f9240e = false;
        this.f9244i = 0;
        this.f9243h = 0;
        this.f9245j = -1;
        if (this.f9241f != null) {
            this.f9241f.recycle();
            this.f9241f = null;
        }
    }
}
