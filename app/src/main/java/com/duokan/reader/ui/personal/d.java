package com.duokan.reader.ui.personal;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.core.sys.af;
import com.duokan.core.ui.j;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.List;

class d implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ c b;

    d(c cVar, Runnable runnable) {
        this.b = cVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        j a = jq.a(this.b.getContext(), "", this.b.getString(com.duokan.c.j.personal__auto_buy_view__deleting), true, true);
        List selectedItems = this.b.a.getSelectedItems();
        List arrayList = new ArrayList();
        for (Object next : selectedItems) {
            if (next instanceof c) {
                ((c) next).a(new af(Boolean.valueOf(false)));
                ((c) next).aL();
                if (!((c) next).a(true)) {
                    arrayList.add((c) next);
                }
            }
        }
        if (arrayList.size() > 0) {
            be.a(this.b.getContext(), String.format(this.b.getString(com.duokan.c.j.personal__auto_buy_view__delete_count), new Object[]{Integer.valueOf(arrayList.size())}), 0).show();
            this.b.a.a(arrayList);
        } else {
            be.a(this.b.getContext(), com.duokan.c.j.personal__auto_buy_view__delete_fail, 0).show();
        }
        a.dismiss();
        this.a.run();
    }

    public void b(ab abVar) {
    }
}
