package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

/* renamed from: com.duokan.reader.ui.reading.a.g */
public class C1426g extends er {
    /* renamed from: a */
    private final dt f9217a = new dt();

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9217a.m1612b(view, z);
        this.f9217a.m1885b(45.0f);
        this.f9217a.m1887c(135.0f);
        this.f9217a.m1882a(AnimUtils.getScaledPagingTouchSlop(view.getContext()));
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof C1428i) {
            this.f9217a.m1611b(view, motionEvent, z, new C1427h(this, motionEvent, (C1428i) esVar));
            return;
        }
        m1613b(false);
    }
}
