package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.google.android.collect.Lists;
import java.util.LinkedList;

class bi implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f9852a = (!bh.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ bh f9853b;

    bi(bh bhVar) {
        this.f9853b = bhVar;
    }

    public void run() {
        this.f9853b.m13792h().setIsHideMarkIcon(false);
        this.f9853b.f9840g.setVisibility(4);
        if (this.f9853b.f9847n) {
            LinkedList g = this.f9853b.m13792h().m14301g();
            if (g.size() > 0) {
                this.f9853b.f9835b.mo1992G().m4200a(Lists.newArrayList(g.toArray(new ah[0])), true);
            } else {
                this.f9853b.f9835b.mo1992G().m4185a(this.f9853b.m13789f());
                C1540p c1540p = (C1540p) AppContext.getAppContext(this.f9853b.f9849p).queryFeature(C1540p.class);
                if (!f9852a && c1540p == null) {
                    throw new AssertionError();
                } else if (c1540p != null) {
                    c1540p.mo2564a(this.f9853b.f9849p, UserInput.DO_BOOK_MARK_GESTURE);
                }
            }
        }
        this.f9853b.f9837d.setVisibility(4);
    }
}
