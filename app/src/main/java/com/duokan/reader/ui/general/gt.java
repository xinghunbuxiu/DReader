package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.core.ui.cv;

class gt extends cv {
    /* renamed from: a */
    final /* synthetic */ gs f7302a;

    gt(gs gsVar, Context context, boolean z) {
        this.f7302a = gsVar;
        super(context, z);
    }

    protected boolean onBack() {
        if (this.f7302a.isActive()) {
            getmActivity().onBackPressed();
        }
        return true;
    }
}
