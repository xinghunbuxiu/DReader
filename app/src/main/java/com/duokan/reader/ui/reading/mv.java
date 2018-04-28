package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class mv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f10647a;
    /* renamed from: b */
    final /* synthetic */ mr f10648b;

    mv(mr mrVar, int i) {
        this.f10648b = mrVar;
        this.f10647a = i;
    }

    public void onClick(View view) {
        this.f10648b.f10643e.mo2439a(this.f10647a - 1);
    }
}
