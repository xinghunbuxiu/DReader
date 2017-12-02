package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.List;

class hj implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ hi b;

    hj(hi hiVar, Runnable runnable) {
        this.b = hiVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        ArrayList arrayList = new ArrayList();
        List selectedItems = this.b.a.getSelectedItems();
        for (int i = 0; i < selectedItems.size(); i++) {
            if (selectedItems.get(i) instanceof ReadBook) {
                arrayList.add((ReadBook) selectedItems.get(i));
            }
        }
        if (arrayList.size() == 0) {
            be.a(this.b.getContext(), j.bookshelf__shared__unselect_any_books, 0).show();
            return;
        }
        com.duokan.core.ui.j a = jq.a(this.b.getContext(), "", this.b.getString(j.personal__readed_books_view__removing), true, true);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ReadBook readBook = (ReadBook) arrayList.get(i2);
            DkUserReadBookManager.a().a(readBook.getBookUuid(), new hk(this, arrayList2, readBook, i2, arrayList, a));
        }
    }

    public void b(ab abVar) {
    }
}
