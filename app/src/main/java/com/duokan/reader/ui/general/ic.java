package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ic implements OnClickListener {
    final /* synthetic */ ia a;
    private int b;

    ic(ia iaVar, int i) {
        this.a = iaVar;
        this.b = i;
    }

    public void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.a(this.b);
        }
        this.a.dismiss();
    }
}
