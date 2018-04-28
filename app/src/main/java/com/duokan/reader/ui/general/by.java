package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class by implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bx f7014a;
    /* renamed from: b */
    private int f7015b;

    by(bx bxVar, int i) {
        this.f7014a = bxVar;
        this.f7015b = i;
    }

    public void onClick(View view) {
        if (this.f7014a.f7013b != null) {
            this.f7014a.f7013b.mo1590a(this.f7015b);
        }
        this.f7014a.dismiss();
    }
}
