package com.duokan.reader.domain.social.message;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class ak extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f5514a;
    /* renamed from: b */
    final /* synthetic */ aj f5515b;
    /* renamed from: c */
    private C0621a<Void> f5516c = null;

    ak(aj ajVar, String str, C0657i c0657i, al alVar) {
        this.f5515b = ajVar;
        this.f5514a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        if (this.f5515b.f5511a.size() > 0) {
            C0639m c0639m = new C0639m((WebSession) this, this.f5514a);
            String str = "";
            for (C1151k c1151k : this.f5515b.f5511a) {
                str = str + "," + c1151k.f5555b;
            }
            if (TextUtils.isEmpty(str)) {
                str = str.substring(1);
            }
            this.f5516c = c0639m.m2907g(str);
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f5514a.m3365a(this.f5515b.f5513c.f5479j)) {
            this.f5515b.f5512b.mo1182a("");
        } else if (this.f5516c.b != 0) {
            this.f5515b.f5512b.mo1182a("");
        } else {
            synchronized (DkMessagesManager.f5470a) {
                aq aqVar = new aq(this.f5515b.f5513c.f5474e, this.f5514a, this.f5515b.f5513c.f5475f);
                aqVar.m8529a();
                aqVar.deleteItems(this.f5515b.f5511a);
                this.f5515b.f5512b.mo1181a();
            }
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f5515b.f5512b.mo1182a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        int i = this.f5516c.b;
        return i == 1001 || i == ICallback.LOGIN_OAUTH_AIDL || i == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
