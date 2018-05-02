package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.general.expandable.ViewMode;

class mr implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ mq b;

    mr(mq mqVar, int i) {
        this.b = mqVar;
        this.a = i;
    }

    public void onClick(View view) {
        if (this.b.f() == ViewMode.Edit) {
            this.b.c.b(0, this.a);
        } else {
            ((kn) MyContextWrapper.getFeature(this.b.a).queryFeature(kn.class)).a((DkCloudStoreBook) this.b.d(this.a));
        }
    }
}
