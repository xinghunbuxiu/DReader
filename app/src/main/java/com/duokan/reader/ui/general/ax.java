package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ax implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkCheckBox f6948a;

    ax(DkCheckBox dkCheckBox) {
        this.f6948a = dkCheckBox;
    }

    public void onClick(View view) {
        this.f6948a.toggle();
        if (this.f6948a.f6781c != null) {
            this.f6948a.f6781c.onClick(this.f6948a);
        }
    }
}
