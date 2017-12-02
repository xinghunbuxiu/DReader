package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.dv;

class ap implements OnClickListener {
    final /* synthetic */ am a;

    ap(am amVar) {
        this.a = amVar;
    }

    public void onClick(View view) {
        if (!this.a.f.isShowing()) {
            dv.a(this.a.getContext());
            this.a.f.show();
        }
    }
}
