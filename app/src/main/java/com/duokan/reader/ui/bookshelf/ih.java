package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.dv;

class ih implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ActivatedController f6610a;
    /* renamed from: b */
    final /* synthetic */ ie f6611b;

    ih(ie ieVar, ActivatedController c0303e) {
        this.f6611b = ieVar;
        this.f6610a = c0303e;
    }

    public void onClick(View view) {
        dv.hideAnimation(this.f6610a.getContentView(), new ii(this));
    }
}
