package com.duokan.reader.ui.personal;

import android.view.View;

import com.duokan.c.j;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.expandable.ViewMode;

class f implements an {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        c h = this.a.a.h(i);
        if (this.a.getViewMode() == ViewMode.Edit) {
            this.a.b(0, i);
            return;
        }
        ap apVar = new ap(this.a.getContext());
        apVar.setPrompt(j.personal__auto_buy_view__delete_single);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new g(this, h));
    }
}
