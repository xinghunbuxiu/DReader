package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class av implements OnClickListener {
    final /* synthetic */ DkCheckBox a;

    av(DkCheckBox dkCheckBox) {
        this.a = dkCheckBox;
    }

    public void onClick(View view) {
        if (this.a.c != null) {
            this.a.c.onClick(this.a);
        }
    }
}
