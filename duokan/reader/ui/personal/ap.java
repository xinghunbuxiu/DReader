package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.UTools;

class ap implements OnClickListener {
    final /* synthetic */ am a;

    ap(am amVar) {
        this.a = amVar;
    }

    public void onClick(View view) {
        if (!this.a.f.isShowing()) {
            UTools.hideSoftInputFromWindow(this.a.getContext());
            this.a.f.show();
        }
    }
}
