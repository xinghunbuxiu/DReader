package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class cc implements OnClickListener {
    final /* synthetic */ bx a;

    cc(bx bxVar) {
        this.a = bxVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_PUSHUP_OPTION", "Comment");
        this.a.a(new cd(this));
    }
}
