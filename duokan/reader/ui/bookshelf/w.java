package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;

class w implements OnClickListener {
    final /* synthetic */ g a;

    w(g gVar) {
        this.a = gVar;
    }

    public void onClick(View view) {
        gx dhVar = new dh(MyContextWrapper.getFeature(this.a.getContext()));
        dhVar.a(dhVar.f() - this.a.f.getViewportBounds().top);
        this.a.c.a(dhVar);
    }
}
