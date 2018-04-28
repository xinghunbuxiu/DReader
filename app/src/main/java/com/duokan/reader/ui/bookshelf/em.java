package com.duokan.reader.ui.bookshelf;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.p024c.C0258j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.ui.general.ip;

class em implements an {
    /* renamed from: a */
    final /* synthetic */ ek f6396a;

    em(ek ekVar) {
        this.f6396a = ekVar;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        if (i == this.f6396a.f6393g.size()) {
            UmengManager.get().onEvent("V2_SHELF_CREATEGROUP", "FromArrange");
            new ip(this.f6396a.getContext(), this.f6396a.getContext().getResources().getString(C0258j.bookshelf__general_shared__new_category_name), "", new en(this)).show();
            return;
        }
        this.f6396a.f6387a.mo1633a((aa) this.f6396a.f6393g.get(i));
    }
}
