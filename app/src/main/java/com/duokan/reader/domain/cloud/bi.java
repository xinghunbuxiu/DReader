package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

import org.json.JSONObject;

class bi extends b {
    final /* synthetic */ a a;
    final /* synthetic */ ab b;
    final /* synthetic */ bh c;
    private com.duokan.reader.common.webservices.b d = null;
    private bk e = new bk();
    private JSONObject f = null;

    bi(bh bhVar, a aVar, ab abVar) {
        this.c = bhVar;
        this.a = aVar;
        this.b = abVar;
    }

    protected void onSessionTry() {
        this.d = new aa((WebSession) this, this.a).a();
        if (this.d.b == 0) {
            this.f = new JSONObject();
            ((JSONObject) this.d.a).put("key", this.b.a);
            this.f.put("__data__", this.d.a);
            this.f.put("__s__", System.currentTimeMillis());
            this.e = this.c.d.a((JSONObject) this.d.a);
        }
    }

    protected void onSessionSucceeded() {
        if (!this.b.a(this.c.d.f)) {
            return;
        }
        if (this.d.b == 1001 || this.d.b == 1002 || this.d.b == 1003) {
            if (this.c.a) {
                i.f().a(this.a.b(), new bj(this));
            } else if (this.c.b != null) {
                this.c.b.a(this.d.b, this.d.c);
            }
        } else if (this.d.b == 0) {
            com.duokan.core.diagnostic.a.c().b(this.f != null);
            this.c.d.e = this.e;
            DkSharedStorageManager.a().a(SharedKey.USER_PRIVILEGE, this.f.toString(), false);
            if (this.c.b != null) {
                this.c.b.a(this.c.d.e);
            }
            this.c.d.d();
        } else if (this.c.b != null) {
            this.c.b.a(this.d.b, this.d.c);
        }
    }

    protected void onSessionFailed() {
        if (this.c.b != null) {
            this.c.b.a(-1, this.c.d.b.getString(com.duokan.b.i.general__shared__network_error));
        }
    }
}
