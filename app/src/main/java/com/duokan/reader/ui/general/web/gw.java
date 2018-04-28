package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import org.json.JSONObject;

class gw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkStoreFictionDetail f7909a;
    /* renamed from: b */
    final /* synthetic */ gv f7910b;

    gw(gv gvVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.f7910b = gvVar;
        this.f7909a = dkStoreFictionDetail;
    }

    public void run() {
        C0800c b = ai.m3980a().m3906b(this.f7910b.f7906a);
        if ((b instanceof ee) && ((ee) b).m4417b(this.f7909a)) {
            ((ee) b).m4418c(this.f7909a);
        }
        JSONObject access$2900 = this.f7910b.f7908c.f7905b.f7581b.jsonSerialDetail(this.f7909a);
        if (access$2900 != null) {
            this.f7910b.f7908c.f7905b.f7581b.web_notifyWeb(this.f7910b.f7907b, 0, access$2900);
        } else {
            this.f7910b.f7908c.f7905b.f7581b.web_notifyWeb(this.f7910b.f7907b, 2, new Object[0]);
        }
    }
}
