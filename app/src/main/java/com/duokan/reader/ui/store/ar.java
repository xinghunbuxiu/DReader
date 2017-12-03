package com.duokan.reader.ui.store;

import com.duokan.b.i;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.ui.general.jq;

final class ar implements a {
    final /* synthetic */ MyContextWrapper a;
    final /* synthetic */ ej b;
    final /* synthetic */ ax c;

    ar(MyContextWrapper mContext, ej ejVar, ax axVar) {
        this.a = mContext;
        this.b = ejVar;
        this.c = axVar;
    }

    public void a(int i, String str) {
    }

    public void a(Object obj) {
        jq jqVar = new jq(this.a);
        jqVar.a(this.a.getString(i.bookcity_store__shared__creating_order));
        jqVar.a(true);
        jqVar.setCancelOnBack(false);
        jqVar.setCancelOnTouchOutside(false);
        jqVar.show();
        o.a().a(this.b.H(), false, false, -1, -1, -1, new as(this, jqVar));
    }
}
