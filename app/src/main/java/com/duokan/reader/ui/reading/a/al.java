package com.duokan.reader.ui.reading.a;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.dt;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.DocPageLayout;
import com.duokan.reader.ui.reading.sh;

public class al extends er {
    private final sh a;
    private final dt c = new dt();

    public al(sh shVar) {
        this.a = shVar;
        this.c.b(1);
    }

    protected void a(View view, boolean z) {
        dt dtVar = this.c;
        boolean z2 = z || !this.c.c();
        dtVar.b(view, z2);
        this.c.b(75.0f);
        this.c.c(105.0f);
        this.c.a(UTools.closeAnimation(view.getContext(), 15.0f));
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        a(view, motionEvent, z, esVar);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.a.M() == DocPageLayout.TOP_TO_BOTTOM || this.a.g()) {
            b(false);
            return;
        }
        this.c.b(view, motionEvent, z, new am(this, motionEvent, (an) esVar));
    }
}
