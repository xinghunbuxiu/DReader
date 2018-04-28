package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class tt implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ tp f10993a;

    tt(tp tpVar) {
        this.f10993a = tpVar;
    }

    public void onClick(View view) {
        if (this.f10993a.m13624k()) {
            if (this.f10993a.f.mo2106b(2)) {
                this.f10993a.f.mo2181w().mo2301l();
            } else {
                this.f10993a.f.at();
            }
            this.f10993a.mo2385d();
            this.f10993a.f9687n.setVisibility(8);
            this.f10993a.f9686m.setVisibility(0);
        }
        UmengManager.get().onEvent("V2_READING_MENU", "Go-Forward");
    }
}
