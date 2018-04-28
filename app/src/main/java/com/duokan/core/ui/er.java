package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public abstract class er {
    /* renamed from: b */
    static final /* synthetic */ boolean f972b = (!er.class.desiredAssertionStatus());
    /* renamed from: a */
    private boolean f973a = true;
    /* renamed from: c */
    private boolean f974c = false;
    /* renamed from: d */
    private boolean f975d = false;
    /* renamed from: e */
    private boolean f976e = false;
    /* renamed from: f */
    private boolean f977f = true;

    /* renamed from: a */
    protected abstract void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar);

    /* renamed from: a */
    protected abstract void mo511a(View view, boolean z);

    /* renamed from: b */
    public final boolean m1614b() {
        return this.f977f;
    }

    /* renamed from: a */
    public final void m1607a(boolean z) {
        this.f977f = z;
    }

    /* renamed from: b */
    public final void m1612b(View view, boolean z) {
        this.f973a = true;
        this.f975d = false;
        this.f974c = false;
        this.f976e = false;
        mo511a(view, z);
    }

    /* renamed from: b */
    public final void m1611b(View view, MotionEvent motionEvent, boolean z, es esVar) {
        m1605a(view, motionEvent, z, false, esVar);
    }

    /* renamed from: a */
    public final void m1605a(View view, MotionEvent motionEvent, boolean z, boolean z2, es esVar) {
        if (this.f977f) {
            this.f975d = false;
            if (!this.f973a) {
                return;
            }
            if (z2) {
                mo526c(view, motionEvent, z, esVar);
            } else {
                mo510a(view, motionEvent, z, esVar);
            }
        }
    }

    /* renamed from: c */
    public final boolean m1618c() {
        if (this.f977f) {
            return this.f973a;
        }
        return false;
    }

    /* renamed from: b */
    protected final void m1613b(boolean z) {
        this.f973a = z;
        if (!this.f973a) {
            this.f974c = false;
            this.f976e = false;
        }
    }

    /* renamed from: d */
    public final boolean m1621d() {
        if (this.f977f) {
            return this.f974c;
        }
        return false;
    }

    /* renamed from: c */
    protected final void m1617c(boolean z) {
        this.f974c = z;
        if (this.f974c) {
            this.f973a = true;
        }
    }

    /* renamed from: e */
    public final boolean m1623e() {
        if (this.f977f) {
            return this.f975d;
        }
        return false;
    }

    /* renamed from: d */
    protected final void m1620d(boolean z) {
        this.f975d = z;
    }

    /* renamed from: f */
    public final boolean m1624f() {
        if (this.f977f) {
            return this.f976e;
        }
        return false;
    }

    /* renamed from: e */
    protected final void m1622e(boolean z) {
        this.f976e = z;
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
    }

    /* renamed from: a */
    protected boolean m1608a(PointF pointF, PointF pointF2, double d, double d2) {
        double a = m1600a(m1601a(pointF, pointF2), d, d + 360.0d);
        if (Double.compare(a, d) >= 0 && Double.compare(a, d2) <= 0) {
            return true;
        }
        a = m1600a(180.0d - m1601a(pointF, pointF2), d, d + 360.0d);
        if (Double.compare(a, d) < 0 || Double.compare(a, d2) > 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    protected double m1600a(double d, double d2, double d3) {
        if (!f972b && d2 >= d3) {
            throw new AssertionError();
        } else if (f972b || Double.compare(Math.abs(d3 - d2), 360.0d) == 0) {
            while (true) {
                if (d >= d2 && d <= d3) {
                    return d;
                }
                if (Double.compare(d, d2) < 0) {
                    d += 360.0d;
                } else {
                    d -= 360.0d;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    protected double m1601a(PointF pointF, PointF pointF2) {
        double b = m1609b(pointF, pointF2);
        if (Double.compare(b, 180.0d) > 0) {
            return b - 180.0d;
        }
        return b;
    }

    /* renamed from: b */
    protected double m1609b(PointF pointF, PointF pointF2) {
        return Math.toDegrees(m1615c(pointF, pointF2));
    }

    /* renamed from: c */
    protected double m1615c(PointF pointF, PointF pointF2) {
        if (f972b || !(pointF == null || pointF2 == null)) {
            PointF pointF3 = new PointF(pointF.x, -pointF.y);
            PointF pointF4 = new PointF(pointF2.x, -pointF2.y);
            if (pointF4.x == pointF3.x) {
                if (pointF4.y > pointF3.y) {
                    return 1.5707963267948966d;
                }
                return 4.71238898038469d;
            } else if (pointF4.y != pointF3.y) {
                double atan = Math.atan(((double) (pointF4.y - pointF3.y)) / ((double) (pointF4.x - pointF3.x)));
                if (pointF4.x < pointF3.x && pointF4.y > pointF3.y) {
                    return 3.141592653589793d + atan;
                }
                if (pointF4.x >= pointF3.x || pointF4.y >= pointF3.y) {
                    return (pointF4.x <= pointF3.x || pointF4.y >= pointF3.y) ? atan : 6.283185307179586d + atan;
                } else {
                    return 3.141592653589793d + atan;
                }
            } else if (pointF4.x > pointF3.x) {
                return 0.0d;
            } else {
                return 3.141592653589793d;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    protected double m1619d(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }

    /* renamed from: a */
    protected int m1602a(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
    }

    /* renamed from: g */
    protected int m1625g() {
        return ViewConfiguration.getLongPressTimeout();
    }

    /* renamed from: b */
    protected int m1610b(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
    }

    /* renamed from: a */
    protected int m1603a(View view, int i) {
        return Math.round(view.getContext().getResources().getDisplayMetrics().density * ((float) i));
    }
}
