package com.duokan.reader.ui.reading.p054a;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.ui.reading.su;
import java.util.List;

/* renamed from: com.duokan.reader.ui.reading.a.ao */
public class ao extends er {
    /* renamed from: a */
    private final su f9204a;
    /* renamed from: c */
    private final ct f9205c = new ct();

    public ao(su suVar) {
        this.f9204a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9205c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!(esVar instanceof aq)) {
            m1613b(false);
        } else if (this.f9204a.mo2007X().mo2329e()) {
            this.f9205c.m1611b(view, motionEvent, z, new ap(this, esVar, motionEvent));
        }
    }

    /* renamed from: a */
    private boolean m12656a(View view, es esVar, MotionEvent motionEvent) {
        View e = this.f9204a.mo2137e((int) motionEvent.getX(), (int) motionEvent.getY());
        if (e == null) {
            return false;
        }
        List<C0798a> h = e.m14302h();
        if (h.isEmpty()) {
            return false;
        }
        if (!(esVar instanceof aq)) {
            return false;
        }
        aq aqVar = (aq) esVar;
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        for (C0798a c0798a : h) {
            Rect[] a = this.f9204a.mo2041a((ea) c0798a);
            if (!TextUtils.isEmpty(c0798a.m4384m())) {
                Rect b = m12659b(view, a, point);
                if (b != null) {
                    b.bottom += dv.m1932b(view.getContext(), 3.0f);
                    aqVar.mo2492a((er) this, e, c0798a, this.f9204a.mo2011a(b));
                    return true;
                }
            }
            if (m12657a(view, this.f9204a.mo2107b(this.f9204a.getDocument().mo1216a((C0897d) c0798a.m3726d(), (C0897d) c0798a.m3728e())), point)) {
                aqVar.mo2491a((er) this, e, c0798a, point);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m12657a(View view, Rect[] rectArr, Point point) {
        int b = dv.m1932b(view.getContext(), 10.0f);
        for (Rect intersects : rectArr) {
            if (intersects.intersects(point.x - b, point.y - b, point.x + b, point.y + b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private Rect m12659b(View view, Rect[] rectArr, Point point) {
        int b = dv.m1932b(view.getContext(), 5.0f);
        for (Rect rect : rectArr) {
            if (rect.intersects(point.x - b, point.y - b, point.x + b, point.y + b)) {
                return rect;
            }
        }
        return null;
    }
}
