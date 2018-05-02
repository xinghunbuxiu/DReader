package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.DocPageLayout;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.al */
public class al extends er {
    /* renamed from: a */
    private final su f9199a;
    /* renamed from: c */
    private final dt f9200c = new dt();

    public al(su suVar) {
        this.f9199a = suVar;
        this.f9200c.m1886b(1);
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        dt dtVar = this.f9200c;
        boolean z2 = z || !this.f9200c.m1618c();
        dtVar.m1612b(view, z2);
        this.f9200c.m1885b(75.0f);
        this.f9200c.m1887c(105.0f);
        this.f9200c.m1882a(dv.m1932b(view.getContext(), 15.0f));
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f9199a.mo1996M() == DocPageLayout.TOP_TO_BOTTOM || this.f9199a.mo2145g()) {
            m1613b(false);
            return;
        }
        this.f9200c.m1611b(view, motionEvent, z, new am(this, motionEvent, (an) esVar));
    }
}
