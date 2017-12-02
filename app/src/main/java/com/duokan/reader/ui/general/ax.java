package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ax implements OnClickListener {
    final /* synthetic */ DkCheckBox a;

    ax(DkCheckBox dkCheckBox) {
        this.a = dkCheckBox;
    }

    public void onClick(View view) {
        this.a.toggle();
        if (this.a.c != null) {
            this.a.c.onClick(this.a);
        }
    }
}
