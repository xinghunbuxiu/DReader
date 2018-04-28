package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class hr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ hp f7347a;
    /* renamed from: b */
    private int f7348b;

    hr(hp hpVar, int i) {
        this.f7347a = hpVar;
        this.f7348b = i;
    }

    public void onClick(View view) {
        if (this.f7347a.f6538b != null) {
            this.f7347a.f6538b.mo1590a(this.f7348b);
        }
        this.f7347a.dismiss();
    }
}
