package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class pz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ py f10842a;

    pz(py pyVar) {
        this.f10842a = pyVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Search");
        this.f10842a.f.aO();
    }
}
