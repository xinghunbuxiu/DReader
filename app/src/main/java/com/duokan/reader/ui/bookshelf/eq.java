package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.AppContext;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.C0613k;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.ui.general.ak;

public class eq {
    /* renamed from: a */
    public ew f6399a;
    /* renamed from: b */
    private final AppContext f6400b;

    public eq(AppContext appContext) {
        this.f6400b = appContext;
    }

    /* renamed from: a */
    public void m9561a(C0800c c0800c) {
        ak akVar = new ak(m9559b());
        akVar.setTitle(C0247i.bookroom__shared__invalid_book_title);
        akVar.addCheckBoxView(C0247i.bookroom__shared__invalid_book_clear);
        akVar.addButtonView(C0247i.general__shared__remove, m9559b().getResources().getColor(C0241c.general__shared__c1));
        akVar.addButtonView(C0247i.general__shared__cancel, m9559b().getResources().getColor(C0241c.general__shared__c6));
        akVar.setOnButtonClickedListener(new er(this, akVar, c0800c));
        akVar.show();
    }

    /* renamed from: a */
    public void m9560a() {
        C0517a esVar = new es(this, new C0613k(Integer.valueOf(0)));
        DkUserPurchasedBooksManager.m5029a().m5053a(esVar);
        DkUserPurchasedFictionsManager.m5072a().m5103b(esVar);
        it.m4692a().m4716a(new ev(this, esVar));
    }

    /* renamed from: b */
    private AppContext m9559b() {
        return this.f6400b;
    }
}
