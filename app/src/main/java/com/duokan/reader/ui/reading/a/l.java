package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.sh;

public class l extends er {
    private final sh a;
    private final ct c = new ct();

    public l(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof n) {
            this.c.b(view, motionEvent, z, new m(this, (n) esVar));
            return;
        }
        b(false);
    }
}
