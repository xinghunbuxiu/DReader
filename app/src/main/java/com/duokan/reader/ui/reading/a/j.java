package com.duokan.reader.ui.reading.a;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.core.ui.g;
import com.duokan.reader.ui.reading.sh;

public class j extends er {
    private final sh a;
    private final RectF c = new RectF();
    private final g d = new g();

    public j(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        g gVar = this.d;
        boolean z2 = z || !this.d.c();
        gVar.b(view, z2);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        this.d.b(view, motionEvent, z, new k(this));
    }
}
