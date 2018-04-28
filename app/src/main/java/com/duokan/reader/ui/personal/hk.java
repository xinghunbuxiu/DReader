package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;

class hk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ActivatedController f8658a;
    /* renamed from: b */
    final /* synthetic */ fz f8659b;

    hk(fz fzVar, ActivatedController c0303e) {
        this.f8659b = fzVar;
        this.f8658a = c0303e;
    }

    public void onClick(View view) {
        this.f8658a.requestDetach();
    }
}
