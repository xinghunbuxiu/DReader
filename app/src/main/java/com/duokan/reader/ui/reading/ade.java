package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.as;
import com.duokan.core.ui.bu;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import org.apache.http.HttpStatus;

public class ade extends er {
    /* renamed from: a */
    final /* synthetic */ TextSelectionController f9507a;
    /* renamed from: c */
    private final bu f9508c = new bu();
    /* renamed from: d */
    private final dt f9509d = new dt();
    /* renamed from: e */
    private final as f9510e = new as();

    public ade(TextSelectionController textSelectionController, Activity activity, su suVar) {
        this.f9507a = textSelectionController;
        this.f9509d.m1882a(dv.getScaledPagingTouchSlop(activity));
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9508c.m1612b(view, z);
        this.f9509d.m1612b(view, z);
        this.f9510e.m1612b(view, z);
        this.f9510e.m1635b(this.f9510e.m1631a() + HttpStatus.SC_MULTIPLE_CHOICES);
        if (!z) {
            m1617c(this.f9507a.m12570d());
        }
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!(esVar instanceof es)) {
            m1613b(false);
        } else if (this.f9507a.f9156e.aE()) {
            m1613b(false);
        } else if (m1618c() && !m1623e()) {
            if (this.f9507a.m12570d()) {
                Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
                Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
                this.f9507a.m12563b(Math.min(point.x, rect.width()), Math.min(point.y, rect.height()), motionEvent.getAction(), view);
                this.f9510e.m1611b(view, motionEvent, z, new adg(this));
            } else {
                this.f9508c.m1611b(view, motionEvent, z, new adf(this, motionEvent));
            }
            if (!this.f9507a.m12576g()) {
                this.f9509d.m1611b(view, motionEvent, z, new adh(this));
            }
        }
    }
}
