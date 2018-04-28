package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.general.expandable.ViewMode;

class lm implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8889a;
    /* renamed from: b */
    final /* synthetic */ int f8890b;
    /* renamed from: c */
    final /* synthetic */ ll f8891c;

    lm(ll llVar, int i, int i2) {
        this.f8891c = llVar;
        this.f8889a = i;
        this.f8890b = i2;
    }

    public void onClick(View view) {
        if (this.f8891c.f8888h.getNormalAdapter().mo1714f() == ViewMode.Edit) {
            this.f8891c.f8888h.m11522b(this.f8889a, this.f8890b);
        } else {
            ((lb) AppContext.getAppContext(this.f8891c.m12080o()).queryFeature(lb.class)).mo1933a(this.f8891c.mo1952j(this.f8890b));
        }
    }
}
