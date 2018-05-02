package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class fz implements OnClickListener {
    final /* synthetic */ fl a;

    fz(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        this.a.a("purchased");
        this.a.a(false, new ga(this));
    }
}
