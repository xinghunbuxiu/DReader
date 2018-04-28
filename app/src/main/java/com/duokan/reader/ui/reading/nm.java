package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

class nm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ nh f10683a;

    nm(nh nhVar) {
        this.f10683a = nhVar;
    }

    public void run() {
        if (this.f10683a.f10673g) {
            this.f10683a.f10672f.m2043a(true);
            this.f10683a.f10669c.setVisibility(0);
            this.f10683a.f10667a.mo2040a(0, 128);
            if (this.f10683a.f10674h && this.f10683a.f10667a.mo1992G().ak() && this.f10683a.f10667a.mo1992G().mo1038k()) {
                DkUserPurchasedFictionsManager.m5072a().m5105b(false, new nn(this));
                return;
            }
            return;
        }
        this.f10683a.f10672f.m2043a(false);
        this.f10683a.f10668b.setForeground(null);
        this.f10683a.f10669c.setVisibility(4);
        this.f10683a.f10667a.mo2040a(128, 0);
    }
}
