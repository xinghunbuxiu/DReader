package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;

class rq implements Runnable {
    final /* synthetic */ qh a;

    rq(qh qhVar) {
        this.a = qhVar;
    }

    public void run() {
        Object obj;
        a.d().a(this.a.f);
        switch (this.a.h.a()) {
            case 0:
                obj = "";
                break;
            case 2:
                obj = "";
                break;
            case 3:
                obj = this.a.getString(j.reading__shared__fail_to_repair_cert);
                break;
            case 4:
                obj = this.a.getString(j.reading__shared__no_open_params);
                break;
            default:
                obj = this.a.getString(j.reading__shared__fail_to_open_book);
                break;
        }
        if (!TextUtils.isEmpty(obj)) {
            this.a.A().prompt(obj);
        }
        this.a.A().goHome(null);
    }
}
