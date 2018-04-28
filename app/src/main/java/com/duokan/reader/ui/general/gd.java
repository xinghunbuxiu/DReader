package com.duokan.reader.ui.general;

import com.duokan.core.ui.aw;
import com.duokan.core.ui.ax;

public abstract class gd extends aw implements ax {
    /* renamed from: c */
    protected fy f7049c = null;
    /* renamed from: d */
    final /* synthetic */ PagesView f7050d;

    protected gd(PagesView pagesView) {
        this.f7050d = pagesView;
    }

    /* renamed from: b */
    public fy mo1765b() {
        return this.f7049c;
    }

    /* renamed from: a */
    public void m10412a(fy fyVar) {
        if (this.f7049c != null) {
            this.f7049c.mo484b(this);
        }
        this.f7049c = fyVar;
        if (this.f7049c != null) {
            this.f7049c.mo483a(this);
        }
        this.f7050d.m9995a(fyVar);
    }
}
