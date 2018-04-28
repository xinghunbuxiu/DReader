package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class oy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ox f10768a;

    oy(ox oxVar) {
        this.f10768a = oxVar;
    }

    public void onClick(View view) {
        if (this.f10768a.f.mo2145g()) {
            UmengManager.get().onEvent("V2_READING_MENU", "PDF-Reflow");
            this.f10768a.m13598a(new oz(this));
            return;
        }
        UmengManager.get().onEvent("V2_READING_MENU", "PDF-Exit-Reflow");
        this.f10768a.m13598a(new pa(this));
    }
}
