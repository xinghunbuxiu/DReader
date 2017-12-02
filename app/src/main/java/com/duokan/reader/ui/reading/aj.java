package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class aj implements OnClickListener {
    final /* synthetic */ ai a;

    aj(ai aiVar) {
        this.a = aiVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Menu");
        this.a.requestShowMenu();
    }
}
