package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class az extends er {
    final /* synthetic */ aq a;
    private final ct c;

    private az(aq aqVar) {
        this.a = aqVar;
        this.c = new ct();
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.a.d()) {
            this.c.b(view, motionEvent, z, new ba(this));
        } else {
            b(false);
        }
    }
}
