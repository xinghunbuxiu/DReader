package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class bz implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8386a;
    /* renamed from: b */
    final /* synthetic */ bx f8387b;

    bz(bx bxVar, int i) {
        this.f8387b = bxVar;
        this.f8386a = i;
    }

    public boolean onLongClick(View view) {
        this.f8387b.f8381a.i.mo1878a(0, this.f8386a);
        return true;
    }
}
