package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

import org.json.JSONObject;

class gl implements Runnable {
    final /* synthetic */ DkStoreFictionDetail a;
    final /* synthetic */ gk b;

    gl(gk gkVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.b = gkVar;
        this.a = dkStoreFictionDetail;
    }

    public void run() {
        c b = ai.a().b(this.b.a);
        if ((b instanceof ej) && ((ej) b).b(this.a)) {
            ((ej) b).c(this.a);
        }
        JSONObject access$2900 = this.b.c.b.b.jsonSerialDetail(this.a);
        if (access$2900 != null) {
            this.b.c.b.b.web_notifyWeb(this.b.b, 0, access$2900);
        } else {
            this.b.c.b.b.web_notifyWeb(this.b.b, 2, new Object[0]);
        }
    }
}
