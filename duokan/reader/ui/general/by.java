package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class by implements OnClickListener {
    final /* synthetic */ bx a;
    private int b;

    by(bx bxVar, int i) {
        this.a = bxVar;
        this.b = i;
    }

    public void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.a(this.b);
        }
        this.a.dismiss();
    }
}
