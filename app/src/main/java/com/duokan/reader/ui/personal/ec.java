package com.duokan.reader.ui.personal;

import android.os.AsyncTask;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;
import java.util.List;

class ec extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ List f8488a;
    /* renamed from: b */
    final /* synthetic */ List f8489b;
    /* renamed from: c */
    final /* synthetic */ ej f8490c;
    /* renamed from: d */
    final /* synthetic */ dm f8491d;

    ec(dm dmVar, List list, List list2, ej ejVar) {
        this.f8491d = dmVar;
        this.f8488a = list;
        this.f8489b = list2;
        this.f8490c = ejVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11719a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m11720a((Void) obj);
    }

    /* renamed from: a */
    protected Void m11719a(Void... voidArr) {
        for (C1068i a : this.f8488a) {
            it.m4692a().m4717a(a);
        }
        return null;
    }

    /* renamed from: a */
    protected void m11720a(Void voidR) {
        super.onPostExecute(voidR);
        for (int i = 0; i < this.f8488a.size(); i++) {
            UmengManager.get().onEvent("V3_SHELF_BOOK_ACTION", "DeleteCloud");
        }
        this.f8491d.m11665b(this.f8489b, this.f8490c);
    }
}
