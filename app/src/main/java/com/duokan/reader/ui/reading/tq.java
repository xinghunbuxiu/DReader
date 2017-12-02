package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class tq implements OnClickListener {
    final /* synthetic */ to a;

    tq(to toVar) {
        this.a = toVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Back");
        this.a.a(new tr(this));
    }
}
