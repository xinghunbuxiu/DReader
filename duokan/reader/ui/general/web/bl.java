package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class bl implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ bk b;

    bl(bk bkVar, String str) {
        this.b = bkVar;
        this.a = str;
    }

    public void onClick(View view) {
        this.b.a.scrollPosToTop(0, ((Integer) this.b.a.mTabsTitle.get(this.a)).intValue(), true);
    }
}
