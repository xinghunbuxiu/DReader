package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ts implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ tp f10992a;

    ts(tp tpVar) {
        this.f10992a = tpVar;
    }

    public void onClick(View view) {
        if (this.f10992a.m13623j()) {
            if (this.f10992a.f.mo2106b(2)) {
                this.f10992a.f.mo2181w().mo2302m();
            } else {
                this.f10992a.f.au();
            }
            this.f10992a.mo2385d();
            this.f10992a.f9686m.setVisibility(8);
            this.f10992a.f9687n.setVisibility(0);
        }
        UmengManager.get().onEvent("V2_READING_MENU", "Go-Back");
    }
}
