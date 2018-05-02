package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.duokan.reader.ui.personal.n */
class C1406n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1405m f8975a;

    C1406n(C1405m c1405m) {
        this.f8975a = c1405m;
    }

    public void onClick(View view) {
        C1404l c1404l = (C1404l) view.getTag();
        if (c1404l != null && !c1404l.f8854e) {
            this.f8975a.post(new C1407o(this, c1404l));
        }
    }
}
