package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.ib;

import java.util.Arrays;

class gv implements ib {
    final /* synthetic */ gu a;

    gv(gu guVar) {
        this.a = guVar;
    }

    public void a(int i) {
        if (i == 0) {
            UmengManager.get().onEvent("V2_SHELF_DELETEBOOK", "FromList");
            this.a.b.a(Arrays.asList(new c[]{this.a.a}), null, null);
        } else if (1 == i) {
            new hd(this.a.getContext(), this.a.a).show();
        }
    }
}
