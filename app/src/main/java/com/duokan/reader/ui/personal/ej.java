package com.duokan.reader.ui.personal;

import android.os.AsyncTask;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.i;

import java.util.List;

class ej extends AsyncTask {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ ep c;
    final /* synthetic */ ds d;

    ej(ds dsVar, List list, List list2, ep epVar) {
        this.d = dsVar;
        this.a = list;
        this.b = list2;
        this.c = epVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected Void a(Void... voidArr) {
        for (i a : this.a) {
            iz.a().a(a);
        }
        return null;
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        for (int i = 0; i < this.a.size(); i++) {
            UmengManager.get().onEvent("V3_SHELF_BOOK_ACTION", "DeleteCloud");
        }
        this.d.b(this.b, this.c);
    }
}
