package com.duokan.reader.ui.bookshelf;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class i implements cg {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.k.setTranslationY((float) (-scrollable.getViewportBounds().top));
    }
}
