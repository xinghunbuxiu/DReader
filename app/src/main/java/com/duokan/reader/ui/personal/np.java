package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class np implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f9008a;
    /* renamed from: b */
    final /* synthetic */ nn f9009b;

    np(nn nnVar, int i) {
        this.f9009b = nnVar;
        this.f9008a = i;
    }

    public boolean onLongClick(View view) {
        this.f9009b.e.mo1878a(this.f9009b.m12354c(), this.f9008a);
        return true;
    }
}
