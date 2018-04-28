package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class qa implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ py f10844a;

    qa(py pyVar) {
        this.f10844a = pyVar;
    }

    public void onClick(View view) {
        this.f10844a.mo2248a(new vd(this.f10844a.getContext()));
        UmengManager.get().onEvent("V2_READING_MENU", "Option");
    }
}
