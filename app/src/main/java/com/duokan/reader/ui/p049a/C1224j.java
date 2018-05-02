package com.duokan.reader.ui.p049a;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.a.j */
class C1224j implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkStoreAbsBook f5716a;
    /* renamed from: b */
    final /* synthetic */ View f5717b;
    /* renamed from: c */
    final /* synthetic */ C1214a f5718c;

    C1224j(C1214a c1214a, DkStoreAbsBook dkStoreAbsBook, View view) {
        this.f5718c = c1214a;
        this.f5716a = dkStoreAbsBook;
        this.f5717b = view;
    }

    public void onClick(View view) {
        ap apVar = new ap(this.f5718c.getContext());
        apVar.setPrompt(C0258j.discovery__edit_feed_view__remove_this_book);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__remove);
        apVar.open(new C1225k(this));
    }
}
