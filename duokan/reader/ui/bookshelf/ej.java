package com.duokan.reader.ui.bookshelf;

import com.duokan.b.i;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.common.k;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.ui.general.ak;

public class ej {
    public ep a;
    private final MyContextWrapper b;

    public ej(MyContextWrapper mContext) {
        this.b = mContext;
    }

    public void a(c cVar) {
        ak akVar = new ak(b());
        akVar.setTitle(i.bookroom__shared__invalid_book_title);
        akVar.addCheckBoxView(i.bookroom__shared__invalid_book_clear);
        akVar.addButtonView(i.general__shared__remove, b().getResources().getColor(com.duokan.b.c.general__shared__c1));
        akVar.addButtonView(i.general__shared__cancel, b().getResources().getColor(com.duokan.b.c.general__shared__c6));
        akVar.setOnButtonClickedListener(new ek(this, akVar, cVar));
        akVar.show();
    }

    public void a() {
        a elVar = new el(this, new k(Integer.valueOf(0)));
        DkUserPurchasedBooksManager.a().a(elVar);
        DkUserPurchasedFictionsManager.a().b(elVar);
        iz.a().a(new eo(this, elVar));
    }

    private MyContextWrapper b() {
        return this.b;
    }
}
