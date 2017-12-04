package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.q;

public class ag extends er {
    private final ak a;
    private final dt c = new dt();
    private final q d = new q();
    private final ct e = new ct();
    private boolean f = false;

    public ag(ak akVar) {
        this.a = akVar;
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        a(view, motionEvent, z, esVar);
    }

    public void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (this.f) {
            this.d.b(view, motionEvent, z, new ah(this));
            if (!e()) {
                if (motionEvent.getActionMasked() == 1) {
                    ak akVar = this.a;
                    if (this.a.e()) {
                        z2 = false;
                    }
                    akVar.a(z2);
                    this.f = false;
                    return;
                }
            }
            return;
        }
        this.c.b(view, motionEvent, z, new ai(this, motionEvent));
        if (this.a.e()) {
            this.e.b(view, motionEvent, z, new aj(this));
        }
    }

    public void a(View view, boolean z) {
        boolean z2 = false;
        this.f = false;
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
        this.e.b(view, z);
        this.d.b(view, z);
    }
}
