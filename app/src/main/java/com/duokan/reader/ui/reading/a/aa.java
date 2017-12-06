package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.reader.ui.reading.sh;

public class aa extends er {
    private final sh a;
    private final ct c = new ct();

    public aa(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        if (esVar instanceof ac) {
            ac acVar = (ac) esVar;
            if (this.a.X().e()) {
                this.c.b(view, motionEvent, z, new ab(this, acVar));
                return;
            }
            return;
        }
        b(false);
    }
}
