package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;

class fs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fo f6467a;

    fs(fo foVar) {
        this.f6467a = foVar;
    }

    public void onClick(View view) {
        ((fm) AppContext.getAppContext(this.f6467a.getContext()).queryFeature(fm.class)).mo1692a();
    }
}
