package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.general.expandable.ViewMode;

class fs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8561a;
    /* renamed from: b */
    final /* synthetic */ fr f8562b;

    fs(fr frVar, int i) {
        this.f8562b = frVar;
        this.f8561a = i;
    }

    public void onClick(View view) {
        if (this.f8562b.c.mo1714f() == ViewMode.Edit) {
            this.f8562b.e.mo1881b(this.f8562b.m11825c(), this.f8561a);
        } else {
            ((lb) AppContext.getAppContext(this.f8562b.b).queryFeature(lb.class)).mo1933a(this.f8562b.m11833c(this.f8561a));
        }
    }
}
