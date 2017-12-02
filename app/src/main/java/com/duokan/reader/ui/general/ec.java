package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;

class ec implements OnClickListener {
    final /* synthetic */ ds a;

    ec(ds dsVar) {
        this.a = dsVar;
    }

    public void onClick(View view) {
        ((ho) x.a(this.a.getContext()).queryFeature(ho.class)).a("", "", "");
    }
}
