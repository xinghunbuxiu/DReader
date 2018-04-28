package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;

class kr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ kq f8831a;

    kr(kq kqVar) {
        this.f8831a = kqVar;
    }

    public void onClick(View view) {
        view.setEnabled(false);
        ((lb) AppContext.getAppContext(this.f8831a.m12080o()).queryFeature(lb.class)).mo1936b();
    }
}
