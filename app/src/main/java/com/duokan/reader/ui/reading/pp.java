package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class pp implements OnClickListener {
    final /* synthetic */ po a;

    pp(po poVar) {
        this.a = poVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Search");
        this.a.f.aO();
    }
}
