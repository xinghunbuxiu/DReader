package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.general.expandable.ViewMode;

class na implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ mz b;

    na(mz mzVar, int i) {
        this.b = mzVar;
        this.a = i;
    }

    public void onClick(View view) {
        if (this.b.c.f() == ViewMode.Edit) {
            this.b.e.b(this.b.c(), this.a);
        } else {
            ((kn) MyContextWrapper.getFeature(this.b.b).queryFeature(kn.class)).a(this.b.c(this.a));
        }
    }
}
