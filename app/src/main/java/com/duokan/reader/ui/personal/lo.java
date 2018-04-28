package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.general.expandable.ViewMode;

class lo implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8895a;
    /* renamed from: b */
    final /* synthetic */ ll f8896b;

    lo(ll llVar, int i) {
        this.f8896b = llVar;
        this.f8895a = i;
    }

    public void onClick(View view) {
        if (this.f8896b.f8888h.getNormalAdapter().mo1714f() == ViewMode.Edit) {
            this.f8896b.f8888h.m11522b(0, this.f8895a);
        } else {
            ((lb) AppContext.getAppContext(this.f8896b.m12080o()).queryFeature(lb.class)).mo1933a(this.f8896b.mo1951i(this.f8895a));
        }
    }
}
