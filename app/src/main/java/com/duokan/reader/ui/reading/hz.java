package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class hz implements OnClickListener {
    final /* synthetic */ hq a;

    hz(hq hqVar) {
        this.a = hqVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_PUSHUP_OPTION", "Comment");
        this.a.a(new ia(this));
    }
}
