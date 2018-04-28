package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class ii implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8715a;
    /* renamed from: b */
    final /* synthetic */ int f8716b;
    /* renamed from: c */
    final /* synthetic */ C1401if f8717c;

    ii(C1401if c1401if, int i, int i2) {
        this.f8717c = c1401if;
        this.f8715a = i;
        this.f8716b = i2;
    }

    public boolean onLongClick(View view) {
        this.f8717c.f8707a.mo2231c(this.f8715a, this.f8716b);
        return true;
    }
}
