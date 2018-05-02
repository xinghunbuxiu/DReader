package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ce implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ cd c;

    ce(cd cdVar, View view, int i) {
        this.c = cdVar;
        this.a = view;
        this.b = i;
    }

    public void onClick(View view) {
        boolean z = false;
        if (this.c.a != null) {
            z = this.c.a.a(this.a, this.b);
        }
        if (!z) {
            this.c.l(this.b);
        }
    }
}
