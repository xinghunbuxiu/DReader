package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class bk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f7631a;
    /* renamed from: b */
    final /* synthetic */ bj f7632b;

    bk(bj bjVar, String str) {
        this.f7632b = bjVar;
        this.f7631a = str;
    }

    public void onClick(View view) {
        this.f7632b.f7630a.scrollPosToTop(0, ((Integer) this.f7632b.f7630a.mTabsTitle.get(this.f7631a)).intValue(), true);
    }
}
