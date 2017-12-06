package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.bu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.reader.ui.reading.sh;

public class r extends er {
    private final sh a;
    private final bu c = new bu();

    public r(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        if (esVar instanceof t) {
            t tVar = (t) esVar;
            if (this.a.X().e()) {
                this.c.b(view, motionEvent, z, new s(this, tVar));
                return;
            }
            return;
        }
        b(false);
    }
}
