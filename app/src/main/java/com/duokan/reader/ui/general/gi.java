package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class gi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bx f7278a;
    /* renamed from: b */
    final /* synthetic */ gh f7279b;

    gi(gh ghVar, bx bxVar) {
        this.f7279b = ghVar;
        this.f7278a = bxVar;
    }

    public void onClick(View view) {
        this.f7278a.cancel();
    }
}
