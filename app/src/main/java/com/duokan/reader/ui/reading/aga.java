package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class aga implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ afz f9697a;

    aga(afz afz) {
        this.f9697a = afz;
    }

    public void onClick(View view) {
        this.f9697a.mo2248a(new ul(this.f9697a.getContext()));
        UmengManager.get().onEvent("V2_READING_MENU", "Mode");
    }
}
