package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class pe implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ox f10775a;

    pe(ox oxVar) {
        this.f10775a = oxVar;
    }

    public void onClick(View view) {
        this.f10775a.mo2248a(this.f10775a.f10767n);
        UmengManager.get().onEvent("V2_READING_MENU", "PDF-View-Type");
    }
}
