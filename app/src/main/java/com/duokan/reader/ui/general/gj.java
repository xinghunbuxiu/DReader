package com.duokan.reader.ui.general;

import com.duokan.core.ui.aw;
import com.duokan.core.ui.ax;

public abstract class gj extends aw implements ax {
    protected ge c = null;
    final /* synthetic */ PagesView d;

    protected gj(PagesView pagesView) {
        this.d = pagesView;
    }

    public ge b() {
        return this.c;
    }

    public void a(ge geVar) {
        if (this.c != null) {
            this.c.b(this);
        }
        this.c = geVar;
        if (this.c != null) {
            this.c.a(this);
        }
        this.d.a(geVar);
    }
}
