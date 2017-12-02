package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.ui.general.expandable.ViewMode;

class fe implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ fd b;

    fe(fd fdVar, int i) {
        this.b = fdVar;
        this.a = i;
    }

    public void onClick(View view) {
        if (this.b.c.f() == ViewMode.Edit) {
            this.b.e.b(this.b.c(), this.a);
        } else {
            ((kn) x.a(this.b.b).queryFeature(kn.class)).a(this.b.c(this.a));
        }
    }
}
