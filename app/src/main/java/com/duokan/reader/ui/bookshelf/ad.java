package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.statistics.C1163a;

class ad implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f6087a;
    /* renamed from: b */
    final /* synthetic */ C1290g f6088b;

    ad(C1290g c1290g, View view) {
        this.f6088b = c1290g;
        this.f6087a = view;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "exposure", "bookshelf_menu");
        he c1287do = new C1287do(AppContext.getAppContext(this.f6088b.getContext()));
        c1287do.m9489a((int) (((float) (c1287do.m9496d() - this.f6088b.f6486f.getViewportBounds().top)) + this.f6087a.getTranslationY()));
        this.f6088b.f6483c.mo1646a(c1287do);
    }
}
