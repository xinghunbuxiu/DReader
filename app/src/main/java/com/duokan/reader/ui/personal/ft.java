package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class ft implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8563a;
    /* renamed from: b */
    final /* synthetic */ fr f8564b;

    ft(fr frVar, int i) {
        this.f8564b = frVar;
        this.f8563a = i;
    }

    public boolean onLongClick(View view) {
        this.f8564b.e.mo1878a(this.f8564b.m11825c(), this.f8563a);
        return true;
    }
}
