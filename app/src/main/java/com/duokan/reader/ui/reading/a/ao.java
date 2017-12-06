package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.ui.reading.sh;

import java.util.List;

public class ao extends er {
    private final sh a;
    private final ct c = new ct();

    public ao(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!(esVar instanceof aq)) {
            b(false);
        } else if (this.a.X().e()) {
            this.c.b(view, motionEvent, z, new ap(this, esVar, motionEvent));
        }
    }

    private boolean a(View view, es esVar, MotionEvent motionEvent) {
        View e = this.a.e((int) motionEvent.getX(), (int) motionEvent.getY());
        if (e == null) {
            return false;
        }
        List<a> h = e.h();
        if (h.isEmpty()) {
            return false;
        }
        if (!(esVar instanceof aq)) {
            return false;
        }
        aq aqVar = (aq) esVar;
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        for (a aVar : h) {
            Rect[] a = this.a.a((ef) aVar);
            if (!TextUtils.isEmpty(aVar.m())) {
                Rect b = b(view, a, point);
                if (b != null) {
                    b.bottom += UTools.getMinimumHeight(view.getContext(), 3.0f);
                    aqVar.a((er) this, e, aVar, this.a.a(b));
                    return true;
                }
            }
            if (a(view, this.a.b(this.a.getDocument().a((d) aVar.d(), (d) aVar.e())), point)) {
                aqVar.a((er) this, e, aVar, point);
                return true;
            }
        }
        return false;
    }

    private boolean a(View view, Rect[] rectArr, Point point) {
        int b = UTools.getMinimumHeight(view.getContext(), 10.0f);
        for (Rect intersects : rectArr) {
            if (intersects.intersects(point.x - b, point.y - b, point.x + b, point.y + b)) {
                return true;
            }
        }
        return false;
    }

    private Rect b(View view, Rect[] rectArr, Point point) {
        int b = UTools.getMinimumHeight(view.getContext(), 5.0f);
        for (Rect rect : rectArr) {
            if (rect.intersects(point.x - b, point.y - b, point.x + b, point.y + b)) {
                return rect;
            }
        }
        return null;
    }
}
