package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.g;

public class cv extends er {
    final /* synthetic */ co a;
    private final g c = new g(2);
    private Pair d = null;

    public cv(co coVar) {
        this.a = coVar;
    }

    protected void a(View view, boolean z) {
        g gVar = this.c;
        boolean z2 = z || !this.c.c();
        gVar.b(view, z2);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.a.a.w().f() && c() && !e() && this.c.c()) {
            if (motionEvent.getAction() == 0) {
                this.d = this.a.a.c(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
            if (this.d != null) {
                e(true);
                this.c.b(view, motionEvent, z, new cw(this));
                return;
            }
            b(false);
        }
    }
}
