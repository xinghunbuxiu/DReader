package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import org.json.JSONObject;

class ba extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f3734a;
    /* renamed from: b */
    final /* synthetic */ al f3735b;
    /* renamed from: c */
    final /* synthetic */ az f3736c;
    /* renamed from: d */
    private C0621a<JSONObject> f3737d = null;
    /* renamed from: e */
    private bb f3738e = new bb();
    /* renamed from: f */
    private JSONObject f3739f = null;

    ba(az azVar, String str, C0657i c0657i, C0672a c0672a, al alVar) {
        this.f3736c = azVar;
        this.f3734a = c0672a;
        this.f3735b = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3737d = new C0652z((WebSession) this, this.f3734a).m3052a();
        if (this.f3737d.b == 0) {
            this.f3739f = new JSONObject();
            ((JSONObject) this.f3737d.f2058a).put("key", this.f3735b.f2360a);
            this.f3739f.put("__data__", this.f3737d.f2058a);
            this.f3739f.put("__s__", System.currentTimeMillis());
            this.f3738e = this.f3736c.f3731c.m5321a((JSONObject) this.f3737d.f2058a);
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3735b.m3365a(this.f3736c.f3731c.f3718f)) {
            return;
        }
        if (this.f3737d.b == 0) {
            WebLog.init().w(this.f3739f != null);
            this.f3736c.f3731c.f3717e = this.f3738e;
            DkSharedStorageManager.m5016a().m5024a(SharedKey.USER_PRIVILEGE, this.f3739f.toString(), false);
            if (this.f3736c.f3729a != null) {
                this.f3736c.f3729a.mo730a(this.f3736c.f3731c.f3717e);
            }
            this.f3736c.f3731c.m5329d();
        } else if (this.f3736c.f3729a != null) {
            this.f3736c.f3729a.mo729a(this.f3737d.b, this.f3737d.c);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3736c.f3729a != null) {
            this.f3736c.f3729a.mo729a(-1, str);
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return (this.f3737d.b == 1001 || this.f3737d.b == ICallback.LOGIN_OAUTH_AIDL || this.f3737d.b == ICallback.CLEAR_ACCOUNT_AIDL) && this.f3736c.f3730b;
    }
}
