package com.duokan.reader.ui.bookshelf;

import android.view.View;

import com.duokan.c.j;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.ui.general.jf;

class ee implements an {
    final /* synthetic */ ec a;

    ee(ec ecVar) {
        this.a = ecVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        if (i == this.a.g.size()) {
            UmengManager.get().onEvent("V2_SHELF_CREATEGROUP", "FromArrange");
            new jf(this.a.getContext(), this.a.getContext().getResources().getString(j.bookshelf__general_shared__new_category_name), "", new ef(this)).show();
            return;
        }
        this.a.a.a((aa) this.a.g.get(i));
    }
}
