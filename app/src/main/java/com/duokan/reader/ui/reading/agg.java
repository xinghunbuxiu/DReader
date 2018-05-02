package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class agg implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ age f9724a;

    private agg(age age) {
        this.f9724a = age;
    }

    public void onClick(View view) {
        this.f9724a.f9719b.dismiss();
        if (this.f9724a.f9721d != null && this.f9724a.f9722e != null) {
            this.f9724a.f9722e.mo2501c(this.f9724a.f9721d);
        }
    }
}
