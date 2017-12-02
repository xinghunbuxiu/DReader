package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;

import com.duokan.b.c;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.common.k;
import com.duokan.reader.ui.general.ak;

class el implements a {
    final /* synthetic */ k a;
    final /* synthetic */ ej b;

    el(ej ejVar, k kVar) {
        this.b = ejVar;
        this.a = kVar;
    }

    public void a(Void voidR) {
        this.a.a(Integer.valueOf(((Integer) this.a.a()).intValue() + 1));
        if (((Integer) this.a.a()).intValue() == 3) {
            a();
        }
    }

    public void a(int i, String str) {
    }

    private void a() {
        ak akVar = new ak(this.b.b());
        akVar.setExtraContentResource(g.bookroom__clear_invalid_book_view);
        akVar.addButtonView(this.b.b().getString(i.general__shared__stop), this.b.b().getResources().getColor(c.general__shared__c1));
        AsyncTask emVar = new em(this, akVar);
        akVar.setOnButtonClickedListener(new en(this, emVar, akVar));
        emVar.execute(new Void[0]);
    }
}
