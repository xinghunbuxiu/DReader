package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class fp implements OnClickListener {
    final /* synthetic */ fl a;

    fp(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        this.a.a("cash");
        this.a.b(false, new fq(this));
    }
}
