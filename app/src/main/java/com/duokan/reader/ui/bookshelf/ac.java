package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.general.hd;

class ac implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1290g f6086a;

    ac(C1290g c1290g) {
        this.f6086a = c1290g;
    }

    public void onClick(View view) {
        ((hd) AppContext.getAppContext(this.f6086a.getContext()).queryFeature(hd.class)).mo2548a("", "", "");
    }
}
