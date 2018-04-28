package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.ui.dv;

class ai implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ af f8259a;

    ai(af afVar) {
        this.f8259a = afVar;
    }

    public void onClick(View view) {
        if (!this.f8259a.f8251f.isShowing()) {
            dv.m1909a(this.f8259a.getContext());
            this.f8259a.f8251f.show();
        }
    }
}
