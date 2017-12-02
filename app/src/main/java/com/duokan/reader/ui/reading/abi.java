package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.dt;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.q;
import com.duokan.reader.ui.general.jn;

final class abi extends er {
    final /* synthetic */ aar a;
    private final dt c = new dt();
    private final q d = new q();
    private PointF e = new PointF(0.0f, 0.0f);
    private PointF f = new PointF(0.0f, 0.0f);
    private float g = 0.0f;
    private boolean h = false;

    public abi(aar com_duokan_reader_ui_reading_aar) {
        this.a = com_duokan_reader_ui_reading_aar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
        this.c.a(dv.d(view.getContext()));
        this.c.a(0.0f);
        this.c.b(-50.0f);
        this.c.c(50.0f);
        this.c.b(2);
        this.d.b(view, z);
        this.d.a((float) a(view, 20));
        this.f = new PointF(0.0f, 0.0f);
        this.e = new PointF(0.0f, 0.0f);
        this.g = 0.0f;
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        a(view, motionEvent, z, esVar);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.a.g()) {
            b(false);
        } else if (this.h) {
            c(true);
            this.d.b(view, motionEvent, z, new abj(this));
            if (!e()) {
                if (motionEvent.getActionMasked() == 1) {
                    int a = a(view, 10);
                    this.f.x = Float.compare(this.f.x, 0.0f) == 0 ? this.g : this.f.x;
                    if (this.a.i != null) {
                        this.a.l();
                    } else if (this.a.d.getDirection() == CurlDirection.PAGE_UP) {
                        if (this.a.a.al()) {
                            if ((-this.f.x) > ((float) a)) {
                                this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) (-dv.b(view.getContext())), 0.0f));
                            } else {
                                this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) dv.b(view.getContext()), 0.0f));
                            }
                        } else if (this.f.x > ((float) a)) {
                            this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) dv.b(view.getContext()), 0.0f));
                        } else {
                            this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) (-dv.b(view.getContext())), 0.0f));
                        }
                    } else if (this.a.d.getDirection() == CurlDirection.PAGE_DOWN) {
                        if (this.a.a.al()) {
                            if (this.f.x > ((float) a)) {
                                this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) dv.b(view.getContext()), 0.0f));
                            } else {
                                this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) (-dv.b(view.getContext())), 0.0f));
                            }
                        } else if ((-this.f.x) > ((float) a)) {
                            this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) (-dv.b(view.getContext())), 0.0f));
                        } else {
                            this.a.d.onDragEnd(new jn(view, motionEvent).a(0, new PointF()), new PointF((float) dv.b(view.getContext()), 0.0f));
                        }
                    }
                    this.h = false;
                    return;
                }
                this.c.b(view, motionEvent, z, new abk(this));
            }
        } else if (motionEvent.getPointerCount() > 1) {
            b(false);
        } else if (this.a.d.isAnimating() || this.a.k) {
            b(false);
            d(true);
        } else {
            this.c.b(view, motionEvent, z, new abl(this));
            if (this.h) {
                a(view, motionEvent, z, esVar);
            }
        }
    }
}
