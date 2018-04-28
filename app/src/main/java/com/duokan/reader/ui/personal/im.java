package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class im implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ij f8736a;

    im(ij ijVar) {
        this.f8736a = ijVar;
    }

    public void onClick(View view) {
        this.f8736a.b.pushHalfPageSmoothly(new hv(this.f8736a.getContext()), null);
    }
}
