package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

class sb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ qr f10930a;

    sb(qr qrVar) {
        this.f10930a = qrVar;
    }

    public void run() {
        Object obj;
        C1167a.m8671d().m8675a(this.f10930a.f9282f);
        switch (this.f10930a.f9284h.m5890a()) {
            case 0:
                obj = "";
                break;
            case 2:
                obj = "";
                break;
            case 3:
                obj = this.f10930a.getString(C0258j.reading__shared__fail_to_repair_cert);
                break;
            case 4:
                obj = this.f10930a.getString(C0258j.reading__shared__no_open_params);
                break;
            default:
                obj = this.f10930a.getString(C0258j.reading__shared__fail_to_open_book);
                break;
        }
        if (!TextUtils.isEmpty(obj)) {
            this.f10930a.m12817A().prompt(obj);
        }
        this.f10930a.m12817A().goHome(null);
    }
}
