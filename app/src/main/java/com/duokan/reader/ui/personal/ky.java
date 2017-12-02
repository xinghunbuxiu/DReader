package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.ui.general.expandable.ViewMode;

class ky implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ kx c;

    ky(kx kxVar, int i, int i2) {
        this.c = kxVar;
        this.a = i;
        this.b = i2;
    }

    public void onClick(View view) {
        if (this.c.h.getNormalAdapter().f() == ViewMode.Edit) {
            this.c.h.b(this.a, this.b);
        } else {
            ((kn) x.a(this.c.o()).queryFeature(kn.class)).a(this.c.j(this.b));
        }
    }
}
