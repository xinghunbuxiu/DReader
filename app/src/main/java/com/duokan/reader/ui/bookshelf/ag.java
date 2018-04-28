package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;

class ag implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1290g f6092a;

    ag(C1290g c1290g) {
        this.f6092a = c1290g;
    }

    public void onClick(View view) {
        ReaderFeature readerFeature = (ReaderFeature) AppContext.getAppContext(this.f6092a.getContext()).queryFeature(ReaderFeature.class);
        readerFeature.switchNightMode(!readerFeature.inNightMode(), true);
        this.f6092a.m9702i();
    }
}
