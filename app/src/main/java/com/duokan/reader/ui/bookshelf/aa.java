package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;

class aa implements OnClickListener {
    final /* synthetic */ g a;

    aa(g gVar) {
        this.a = gVar;
    }

    public void onClick(View view) {
        ReaderFeature readerFeature = (ReaderFeature) x.a(this.a.getContext()).queryFeature(ReaderFeature.class);
        readerFeature.switchNightMode(!readerFeature.inNightMode(), true);
        this.a.i();
    }
}
