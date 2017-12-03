package com.duokan.reader.ui.reading;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;
import com.google.android.collect.Lists;

import java.util.LinkedList;

class bi implements Runnable {
    static final /* synthetic */ boolean a = (!bh.class.desiredAssertionStatus());
    final /* synthetic */ bh b;

    bi(bh bhVar) {
        this.b = bhVar;
    }

    public void run() {
        this.b.h().setIsHideMarkIcon(false);
        this.b.g.setVisibility(4);
        if (this.b.n) {
            LinkedList g = this.b.h().g();
            if (g.size() > 0) {
                this.b.b.G().a(Lists.newArrayList(g.toArray(new ah[0])), true);
            } else {
                this.b.b.G().a(this.b.f());
                p pVar = (p) MyContextWrapper.getFeature(this.b.p).queryFeature(p.class);
                if (!a && pVar == null) {
                    throw new AssertionError();
                } else if (pVar != null) {
                    pVar.a(this.b.p, UserInput.DO_BOOK_MARK_GESTURE);
                }
            }
        }
        this.b.d.setVisibility(4);
    }
}
