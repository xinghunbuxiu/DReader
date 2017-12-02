package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.List;

class eu implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ eq b;

    eu(eq eqVar, Runnable runnable) {
        this.b = eqVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        List arrayList = new ArrayList();
        List j = this.b.getAdapter().j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) instanceof CustomCloudItem) {
                arrayList.add((CustomCloudItem) j.get(i));
            }
        }
        if (arrayList.size() == 0) {
            be.a(this.b.getContext(), j.bookshelf__shared__unselect_any_books, 0).show();
            return;
        }
        this.b.l.a(arrayList, new ev(this, jq.a(this.b.getContext(), "", this.b.getResources().getString(j.bookshelf__cloud_books_view__deleting), true, true)));
    }

    public void b(ab abVar) {
    }
}
