package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

public class g extends er {
    private final dt a = new dt();

    protected void a(View view, boolean z) {
        this.a.b(view, z);
        this.a.b(45.0f);
        this.a.c(135.0f);
        this.a.a(UTools.getScaledPagingTouchSlop(view.getContext()));
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof i) {
            this.a.b(view, motionEvent, z, new h(this, motionEvent, (i) esVar));
            return;
        }
        b(false);
    }
}
