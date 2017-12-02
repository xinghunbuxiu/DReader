package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.core.ui.ay;

public abstract class gg extends ay {
    final /* synthetic */ PagesView d;

    public gg(PagesView pagesView, Context context) {
        this.d = pagesView;
        super(context, null);
    }

    protected final void o() {
        super.j();
    }

    protected final void p() {
        super.i();
    }

    protected final void q() {
        super.l();
    }

    protected final int a(int i) {
        if (s(i)) {
            return super.l(i);
        }
        return 0;
    }

    protected final int b(int i) {
        if (s(i)) {
            return super.m(i);
        }
        return 0;
    }

    protected final int d(int i) {
        if (s(i)) {
            return super.n(i);
        }
        return 0;
    }

    protected final int e(int i) {
        if (s(i)) {
            return super.o(i);
        }
        return 0;
    }
}
