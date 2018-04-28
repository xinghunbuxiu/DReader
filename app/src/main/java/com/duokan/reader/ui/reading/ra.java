package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class ra extends er {
    /* renamed from: a */
    final /* synthetic */ qr f10883a;

    ra(qr qrVar) {
        this.f10883a = qrVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (motionEvent.getActionMasked() == 0 && motionEvent.getY() < ((float) m1603a(view, 20))) {
            m1617c(true);
            m1620d(true);
        }
    }
}
