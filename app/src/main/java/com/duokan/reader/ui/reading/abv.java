package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0392q;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.general.ix;
import fi.harism.curl.CurlDirection;

final class abv extends er {
    /* renamed from: a */
    final /* synthetic */ abe f9424a;
    /* renamed from: c */
    private final dt f9425c = new dt();
    /* renamed from: d */
    private final C0392q f9426d = new C0392q();
    /* renamed from: e */
    private PointF f9427e = new PointF(0.0f, 0.0f);
    /* renamed from: f */
    private PointF f9428f = new PointF(0.0f, 0.0f);
    /* renamed from: g */
    private float f9429g = 0.0f;
    /* renamed from: h */
    private boolean f9430h = false;

    public abv(abe abe) {
        this.f9424a = abe;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9425c.m1612b(view, z);
        this.f9425c.m1882a(AnimUtils.getScaledTouchSlop(view.getContext()));
        this.f9425c.m1881a(0.0f);
        this.f9425c.m1885b(-50.0f);
        this.f9425c.m1887c(50.0f);
        this.f9425c.m1886b(2);
        this.f9426d.m1612b(view, z);
        this.f9426d.m2168a((float) m1603a(view, 20));
        this.f9428f = new PointF(0.0f, 0.0f);
        this.f9427e = new PointF(0.0f, 0.0f);
        this.f9429g = 0.0f;
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.f9424a.m13223g()) {
            m1613b(false);
        } else if (this.f9430h) {
            m1617c(true);
            this.f9426d.m1611b(view, motionEvent, z, new abw(this));
            if (!m1623e()) {
                if (motionEvent.getActionMasked() == 1) {
                    int a = m1603a(view, 10);
                    this.f9428f.x = Float.compare(this.f9428f.x, 0.0f) == 0 ? this.f9429g : this.f9428f.x;
                    if (this.f9424a.f9387i != null) {
                        this.f9424a.m13232l();
                    } else if (this.f9424a.f9382d.getDirection() == CurlDirection.PAGE_UP) {
                        if (this.f9424a.f9379a.al()) {
                            if ((-this.f9428f.x) > ((float) a)) {
                                this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) (-AnimUtils.getScaledMinimumFlingVelocity(view.getContext())), 0.0f));
                            } else {
                                this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) AnimUtils.getScaledMinimumFlingVelocity(view.getContext()), 0.0f));
                            }
                        } else if (this.f9428f.x > ((float) a)) {
                            this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) AnimUtils.getScaledMinimumFlingVelocity(view.getContext()), 0.0f));
                        } else {
                            this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) (-AnimUtils.getScaledMinimumFlingVelocity(view.getContext())), 0.0f));
                        }
                    } else if (this.f9424a.f9382d.getDirection() == CurlDirection.PAGE_DOWN) {
                        if (this.f9424a.f9379a.al()) {
                            if (this.f9428f.x > ((float) a)) {
                                this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) AnimUtils.getScaledMinimumFlingVelocity(view.getContext()), 0.0f));
                            } else {
                                this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) (-AnimUtils.getScaledMinimumFlingVelocity(view.getContext())), 0.0f));
                            }
                        } else if ((-this.f9428f.x) > ((float) a)) {
                            this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) (-AnimUtils.getScaledMinimumFlingVelocity(view.getContext())), 0.0f));
                        } else {
                            this.f9424a.f9382d.onDragEnd(new ix(view, motionEvent).m10817a(0, new PointF()), new PointF((float) AnimUtils.getScaledMinimumFlingVelocity(view.getContext()), 0.0f));
                        }
                    }
                    this.f9430h = false;
                    return;
                }
                this.f9425c.m1611b(view, motionEvent, z, new abx(this));
            }
        } else if (motionEvent.getPointerCount() > 1) {
            m1613b(false);
        } else if (this.f9424a.f9382d.isAnimating() || this.f9424a.f9389k) {
            m1613b(false);
            m1620d(true);
        } else {
            this.f9425c.m1611b(view, motionEvent, z, new aby(this));
            if (this.f9430h) {
                mo510a(view, motionEvent, z, esVar);
            }
        }
    }
}
