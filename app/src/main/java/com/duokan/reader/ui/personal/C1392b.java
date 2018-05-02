package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

/* renamed from: com.duokan.reader.ui.personal.b */
class C1392b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1391a f8302a;

    C1392b(C1391a c1391a) {
        this.f8302a = c1391a;
    }

    public void onClick(View view) {
        UmengManager.get().checkUpdateManual(this.f8302a.getContext());
    }
}
