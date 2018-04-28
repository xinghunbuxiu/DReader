package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ce implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f7027a;
    /* renamed from: b */
    final /* synthetic */ int f7028b;
    /* renamed from: c */
    final /* synthetic */ cd f7029c;

    ce(cd cdVar, View view, int i) {
        this.f7029c = cdVar;
        this.f7027a = view;
        this.f7028b = i;
    }

    public void onClick(View view) {
        boolean z = false;
        if (this.f7029c.f7023a != null) {
            z = this.f7029c.f7023a.mo2453a(this.f7027a, this.f7028b);
        }
        if (!z) {
            this.f7029c.m10340l(this.f7028b);
        }
    }
}
