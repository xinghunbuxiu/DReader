package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class gm implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8614a;

    gm(fz fzVar) {
        this.f8614a = fzVar;
    }

    public void onClick(View view) {
        this.f8614a.m11853a("purchased");
        this.f8614a.m11855a(false, new gn(this));
    }
}
