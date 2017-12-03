package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.general.expandable.ViewMode;

class lr implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ DkCloudStoreBook c;
    final /* synthetic */ lq d;

    lr(lq lqVar, int i, int i2, DkCloudStoreBook dkCloudStoreBook) {
        this.d = lqVar;
        this.a = i;
        this.b = i2;
        this.c = dkCloudStoreBook;
    }

    public void onClick(View view) {
        if (this.d.f() == ViewMode.Edit) {
            this.d.i.b(this.a, this.b);
        } else {
            ((kn) MyContextWrapper.getFeature(this.d.o()).queryFeature(kn.class)).a(this.c);
        }
    }
}
