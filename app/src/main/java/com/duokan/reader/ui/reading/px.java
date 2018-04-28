package com.duokan.reader.ui.reading;

import android.content.Context;
import com.duokan.core.ui.C0394t;

class px extends C0394t {
    /* renamed from: a */
    final /* synthetic */ Runnable f10840a;
    /* renamed from: b */
    final /* synthetic */ pm f10841b;

    px(pm pmVar, Context context, Runnable runnable) {
        this.f10841b = pmVar;
        this.f10840a = runnable;
        super(context);
    }

    public boolean onBack() {
        this.f10840a.run();
        return true;
    }
}
