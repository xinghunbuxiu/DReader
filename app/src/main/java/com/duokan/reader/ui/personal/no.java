package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.general.expandable.ViewMode;

class no implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f9006a;
    /* renamed from: b */
    final /* synthetic */ nn f9007b;

    no(nn nnVar, int i) {
        this.f9007b = nnVar;
        this.f9006a = i;
    }

    public void onClick(View view) {
        if (this.f9007b.c.mo1714f() == ViewMode.Edit) {
            this.f9007b.e.mo1881b(this.f9007b.m12354c(), this.f9006a);
        } else {
            ((lb) AppContext.getAppContext(this.f9007b.b).queryFeature(lb.class)).mo1933a(this.f9007b.m12362c(this.f9006a));
        }
    }
}
