package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class aj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ai f9770a;

    aj(ai aiVar) {
        this.f9770a = aiVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Menu");
        this.f9770a.requestShowMenu();
    }
}
