package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.reading.sh;

public class o extends er {
    private final sh a;
    private final ct c = new ct();

    public o(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof q) {
            q qVar = (q) esVar;
            if (this.a.X().e()) {
                this.c.b(view, motionEvent, z, new p(this, qVar));
                return;
            }
            return;
        }
        b(false);
    }

    private ae a(Point point) {
        as aa = this.a.aa();
        if (aa == null) {
            return null;
        }
        ae a = aa.a(point);
        if (a == null) {
            a = aa.a(new Point(point.x, point.y - (aa.p().f / 2)));
        }
        if (a == null) {
            return aa.a(new Point(point.x, point.y + (aa.p().f / 2)));
        }
        return a;
    }
}
