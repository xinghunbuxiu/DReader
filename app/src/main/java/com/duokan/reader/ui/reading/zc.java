package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnLongClickListener;

class zc implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ zb f11262a;

    zc(zb zbVar) {
        this.f11262a = zbVar;
    }

    public boolean onLongClick(View view) {
        this.f11262a.D.put("Action1", "NOTE");
        this.f11262a.f11261E.mo2210c();
        this.f11262a.f11261E.mo2213f();
        return false;
    }
}
