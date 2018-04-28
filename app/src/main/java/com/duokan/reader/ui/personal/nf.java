package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.general.expandable.ViewMode;

class nf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8982a;
    /* renamed from: b */
    final /* synthetic */ ne f8983b;

    nf(ne neVar, int i) {
        this.f8983b = neVar;
        this.f8982a = i;
    }

    public void onClick(View view) {
        if (this.f8983b.mo1714f() == ViewMode.Edit) {
            this.f8983b.f8867c.mo1881b(0, this.f8982a);
        } else {
            ((lb) AppContext.getAppContext(this.f8983b.f8866a).queryFeature(lb.class)).mo1933a((DkCloudStoreBook) this.f8983b.mo509d(this.f8982a));
        }
    }
}
