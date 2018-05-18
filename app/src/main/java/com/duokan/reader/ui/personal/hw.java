package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.ui.BaseDialog;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.List;

class hw implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8675a;
    /* renamed from: b */
    final /* synthetic */ hv f8676b;

    hw(hv hvVar, Runnable runnable) {
        this.f8676b = hvVar;
        this.f8675a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        ArrayList arrayList = new ArrayList();
        List selectedItems = this.f8676b.f8673a.getSelectedItems();
        for (int i = 0; i < selectedItems.size(); i++) {
            if (selectedItems.get(i) instanceof ReadBook) {
                arrayList.add((ReadBook) selectedItems.get(i));
            }
        }
        if (arrayList.size() == 0) {
            be.m10286a(this.f8676b.getContext(), C0258j.bookshelf__shared__unselect_any_books, 0).show();
            return;
        }
        BaseDialog a = ja.m10832a(this.f8676b.getContext(), "", this.f8676b.getString(C0258j.personal__readed_books_view__removing), true, true);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ReadBook readBook = (ReadBook) arrayList.get(i2);
            DkUserReadBookManager.m5115a().m5130a(readBook.getBookUuid(), new hx(this, arrayList2, readBook, i2, arrayList, a));
        }
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
