package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.sys.af;
import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.duokan.reader.ui.personal.d */
class C1394d implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8442a;
    /* renamed from: b */
    final /* synthetic */ C1393c f8443b;

    C1394d(C1393c c1393c, Runnable runnable) {
        this.f8443b = c1393c;
        this.f8442a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        C0342j a = ja.m10832a(this.f8443b.getContext(), "", this.f8443b.getString(C0258j.personal__auto_buy_view__deleting), true, true);
        List selectedItems = this.f8443b.f8388a.getSelectedItems();
        List arrayList = new ArrayList();
        for (Object next : selectedItems) {
            if (next instanceof C0800c) {
                ((C0800c) next).mo1009a(new af(Boolean.valueOf(false)));
                ((C0800c) next).aN();
                if (!((C0800c) next).mo1012a(true)) {
                    arrayList.add((C0800c) next);
                }
            }
        }
        if (arrayList.size() > 0) {
            be.m10287a(this.f8443b.getContext(), String.format(this.f8443b.getString(C0258j.personal__auto_buy_view__delete_count), new Object[]{Integer.valueOf(arrayList.size())}), 0).show();
            this.f8443b.f8388a.m11715a(arrayList);
        } else {
            be.m10286a(this.f8443b.getContext(), C0258j.personal__auto_buy_view__delete_fail, 0).show();
        }
        a.dismiss();
        this.f8442a.run();
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
