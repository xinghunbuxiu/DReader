package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

class nc implements Runnable {
    final /* synthetic */ mx a;

    nc(mx mxVar) {
        this.a = mxVar;
    }

    public void run() {
        if (this.a.g) {
            this.a.f.a(true);
            this.a.c.setVisibility(0);
            this.a.a.a(0, 128);
            if (this.a.h && this.a.a.G().ai() && this.a.a.G().k()) {
                DkUserPurchasedFictionsManager.a().b(false, new nd(this));
                return;
            }
            return;
        }
        this.a.f.a(false);
        this.a.b.setForeground(null);
        this.a.c.setVisibility(4);
        this.a.a.a(128, 0);
    }
}
