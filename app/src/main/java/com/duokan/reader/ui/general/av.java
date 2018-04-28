package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class av implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkCheckBox f6946a;

    av(DkCheckBox dkCheckBox) {
        this.f6946a = dkCheckBox;
    }

    public void onClick(View view) {
        if (this.f6946a.f6781c != null) {
            this.f6946a.f6781c.onClick(this.f6946a);
        }
    }
}
