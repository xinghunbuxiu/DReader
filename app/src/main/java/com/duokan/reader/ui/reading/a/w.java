package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.cd;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

public class w extends er {
    private ct a = new ct();
    private cd c = new cd();
    private z d;

    public w(z zVar) {
        this.d = zVar;
    }

    protected void a(View view, boolean z) {
        this.a.b(view, z);
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        this.a.b(view, motionEvent, z, new x(this));
        this.c.b(view, motionEvent, z, new y(this));
    }
}
