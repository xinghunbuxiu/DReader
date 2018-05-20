package com.duokan.core.ui;

import android.view.View;

class ag implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ an f898a;
    /* renamed from: b */
    final /* synthetic */ HatGridView f899b;

    ag(HatGridView hatGridView, an anVar) {
        this.f899b = hatGridView;
        this.f898a = anVar;
    }

    /* renamed from: a */
    public void onItemClick(ay ayVar, View view, int i) {
        this.f898a.mo1558a(this.f899b, view, i);
    }
}
