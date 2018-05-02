package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class ts implements OnClickListener {
    final /* synthetic */ to a;

    ts(to toVar) {
        this.a = toVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Navigation");
        if (this.a.l()) {
            this.a.dismissTopPopup();
        }
        this.a.h = true;
        this.a.a(new tt(this));
    }
}
