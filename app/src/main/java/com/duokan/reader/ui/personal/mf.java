package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.general.expandable.ViewMode;

class mf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8932a;
    /* renamed from: b */
    final /* synthetic */ int f8933b;
    /* renamed from: c */
    final /* synthetic */ DkCloudStoreBook f8934c;
    /* renamed from: d */
    final /* synthetic */ me f8935d;

    mf(me meVar, int i, int i2, DkCloudStoreBook dkCloudStoreBook) {
        this.f8935d = meVar;
        this.f8932a = i;
        this.f8933b = i2;
        this.f8934c = dkCloudStoreBook;
    }

    public void onClick(View view) {
        if (this.f8935d.mo1714f() == ViewMode.Edit) {
            this.f8935d.f8930i.m11522b(this.f8932a, this.f8933b);
        } else {
            ((lb) AppContext.getAppContext(this.f8935d.m12080o()).queryFeature(lb.class)).mo1933a(this.f8934c);
        }
    }
}
