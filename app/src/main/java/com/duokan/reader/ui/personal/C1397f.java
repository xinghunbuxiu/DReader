package com.duokan.reader.ui.personal;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.expandable.ViewMode;

/* renamed from: com.duokan.reader.ui.personal.f */
class C1397f implements an {
    /* renamed from: a */
    final /* synthetic */ C1396e f8531a;

    C1397f(C1396e c1396e) {
        this.f8531a = c1396e;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        C0800c h = this.f8531a.f8478a.m12035h(i);
        if (this.f8531a.getViewMode() == ViewMode.Edit) {
            this.f8531a.m11522b(0, i);
            return;
        }
        ap apVar = new ap(this.f8531a.getContext());
        apVar.setPrompt(C0258j.personal__auto_buy_view__delete_single);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new C1398g(this, h));
    }
}
