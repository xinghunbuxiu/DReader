package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.List;

class eo implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8512a;
    /* renamed from: b */
    final /* synthetic */ ek f8513b;

    eo(ek ekVar, Runnable runnable) {
        this.f8513b = ekVar;
        this.f8512a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        List arrayList = new ArrayList();
        List j = this.f8513b.getAdapter().m9788j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) instanceof CustomCloudItem) {
                arrayList.add((CustomCloudItem) j.get(i));
            }
        }
        if (arrayList.size() == 0) {
            be.m10286a(this.f8513b.getContext(), C0258j.bookshelf__shared__unselect_any_books, 0).show();
            return;
        }
        this.f8513b.f8503m.mo1900a(arrayList, new ep(this, ja.m10832a(this.f8513b.getContext(), "", this.f8513b.getResources().getString(C0258j.bookshelf__cloud_books_view__deleting), true, true)));
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
