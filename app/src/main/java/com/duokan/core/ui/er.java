package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public abstract class er {
    static final /* synthetic */ boolean b = (!er.class.desiredAssertionStatus());
    private boolean a = true;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = true;

    protected abstract void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar);

    protected abstract void a(View view, boolean z);

    public final boolean b() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void b(View view, boolean z) {
        this.a = true;
        this.d = false;
        this.c = false;
        this.e = false;
        a(view, z);
    }

    public final void b(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        a(view, motionEvent, z, false, esVar);
    }

    public final void a(View view, MotionEvent motionEvent, boolean z, boolean z2, OnTouchChangeListener esVar) {
        if (this.f) {
            this.d = false;
            if (!this.a) {
                return;
            }
            if (z2) {
                c(view, motionEvent, z, esVar);
            } else {
                a(view, motionEvent, z, esVar);
            }
        }
    }

    public final boolean c() {
        if (this.f) {
            return this.a;
        }
        return false;
    }

    protected final void b(boolean z) {
        this.a = z;
        if (!this.a) {
            this.c = false;
            this.e = false;
        }
    }

    public final boolean d() {
        if (this.f) {
            return this.c;
        }
        return false;
    }

    protected final void c(boolean z) {
        this.c = z;
        if (this.c) {
            this.a = true;
        }
    }

    public final boolean e() {
        if (this.f) {
            return this.d;
        }
        return false;
    }

    protected final void d(boolean z) {
        this.d = z;
    }

    public final boolean f() {
        if (this.f) {
            return this.e;
        }
        return false;
    }

    protected final void e(boolean z) {
        this.e = z;
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
    }

    protected boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        double a = a(a(pointF, pointF2), d, d + 360.0d);
        if (Double.compare(a, d) >= 0 && Double.compare(a, d2) <= 0) {
            return true;
        }
        a = a(180.0d - a(pointF, pointF2), d, d + 360.0d);
        if (Double.compare(a, d) < 0 || Double.compare(a, d2) > 0) {
            return false;
        }
        return true;
    }

    protected double a(double d, double d2, double d3) {
        if (!b && d2 >= d3) {
            throw new AssertionError();
        } else if (b || Double.compare(Math.abs(d3 - d2), 360.0d) == 0) {
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

    protected double a(PointF pointF, PointF pointF2) {
        double b = b(pointF, pointF2);
        if (Double.compare(b, 180.0d) > 0) {
            return b - 180.0d;
        }
        return b;
    }

    protected double b(PointF pointF, PointF pointF2) {
        return Math.toDegrees(c(pointF, pointF2));
    }

    protected double c(PointF pointF, PointF pointF2) {
        if (b || !(pointF == null || pointF2 == null)) {
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

    protected double d(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }

    protected int a(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
    }

    protected int g() {
        return ViewConfiguration.getLongPressTimeout();
    }

    protected int b(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
    }

    protected int a(View view, int i) {
        return Math.round(view.getContext().getResources().getDisplayMetrics().density * ((float) i));
    }
}
