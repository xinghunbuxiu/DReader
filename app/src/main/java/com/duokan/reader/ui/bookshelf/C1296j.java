package com.duokan.reader.ui.bookshelf;

import com.duokan.core.ui.AnimUtils;
import java.util.concurrent.Callable;

/* renamed from: com.duokan.reader.ui.bookshelf.j */
class C1296j implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ int f6647a;
    /* renamed from: b */
    final /* synthetic */ C1290g f6648b;

    C1296j(C1290g c1290g, int i) {
        this.f6648b = c1290g;
        this.f6647a = i;
    }

    public /* synthetic */ Object call() {
        return m9854a();
    }

    /* renamed from: a */
    public Boolean m9854a() {
        if (this.f6648b.f6495o != this) {
            return Boolean.valueOf(true);
        }
        this.f6648b.f6495o = null;
        if (this.f6648b.getWindowToken() == null) {
            return Boolean.valueOf(true);
        }
        this.f6648b.f6485e.m9459b(this.f6648b.f6482b.m9444d());
        if (this.f6648b.f6488h != null) {
            this.f6648b.f6488h.m9804a(false);
        }
        if (this.f6648b.f6489i.getVisibility() == 0) {
            AnimUtils.m1921a(this.f6648b.f6489i, new C1297k(this));
        }
        return Boolean.valueOf(false);
    }
}
