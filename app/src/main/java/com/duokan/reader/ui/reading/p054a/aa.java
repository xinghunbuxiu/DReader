package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.aa */
public class aa extends er {
    /* renamed from: a */
    private final su f9181a;
    /* renamed from: c */
    private final ct f9182c = new ct();

    public aa(su suVar) {
        this.f9181a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9182c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof ac) {
            ac acVar = (ac) esVar;
            if (this.f9181a.mo2007X().mo2329e()) {
                this.f9182c.m1611b(view, motionEvent, z, new ab(this, acVar));
                return;
            }
            return;
        }
        m1613b(false);
    }
}
