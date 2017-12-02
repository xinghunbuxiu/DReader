package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.ui.general.expandable.ViewMode;

class la implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ kx b;

    la(kx kxVar, int i) {
        this.b = kxVar;
        this.a = i;
    }

    public void onClick(View view) {
        if (this.b.h.getNormalAdapter().f() == ViewMode.Edit) {
            this.b.h.b(0, this.a);
        } else {
            ((kn) x.a(this.b.o()).queryFeature(kn.class)).a(this.b.i(this.a));
        }
    }
}
