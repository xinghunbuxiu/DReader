package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.dt;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.q;

public class c extends er {
    private final f a;
    private final dt c = new dt();
    private final q d = new q();
    private boolean e = false;

    public c(f fVar) {
        this.a = fVar;
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (motionEvent.getX() < ((float) UTools.closeAnimation(view.getContext(), 23.0f))) {
            c(true);
        } else if (!(this.a.a() || this.e)) {
            b(false);
        }
        a(view, motionEvent, z, esVar);
    }

    public void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        this.d.b(view, motionEvent, z, new d(this));
        if (this.e) {
            if (!e()) {
                if (motionEvent.getActionMasked() == 1) {
                    f fVar = this.a;
                    if (this.a.a()) {
                        z2 = false;
                    }
                    fVar.a(z2);
                    this.e = false;
                    return;
                }
            }
            return;
        }
        this.c.b(view, motionEvent, z, new e(this));
    }

    public void a(View view, boolean z) {
        boolean z2 = false;
        this.e = false;
        dt dtVar = this.c;
        if (z || !this.c.c()) {
            z2 = true;
        }
        dtVar.b(view, z2);
        this.c.a(UTools.getScaledPagingTouchSlop(view.getContext()));
        this.c.a(0.0f);
        this.c.b(-30.0f);
        this.c.c(30.0f);
        this.c.b(1);
        this.d.b(view, z);
    }
}
