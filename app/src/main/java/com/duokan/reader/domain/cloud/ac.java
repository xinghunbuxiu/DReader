package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.p039e.C0606a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.mipay.sdk.Mipay;
import org.w3c.dom.Node;

class ac extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f3650a;
    /* renamed from: b */
    final /* synthetic */ ab f3651b;
    /* renamed from: c */
    private C0621a<Node> f3652c = null;

    ac(ab abVar, String str, C0657i c0657i, C0672a c0672a) {
        this.f3651b = abVar;
        this.f3650a = c0672a;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3652c = new DkSyncService((WebSession) this, this.f3650a).m2826a(this.f3651b.f3645a, this.f3651b.f3646b, 0);
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3652c.b == 0 || this.f3652c.b == 7) {
            try {
                this.f3651b.f3648d.mo1969a(new DkCloudReadingInfo(this.f3651b.f3646b, this.f3651b.f3647c, (Node) this.f3652c.f2058a, C0606a.m2773a(C0606a.m2783f((Node) this.f3652c.f2058a, Mipay.KEY_RESULT), "latestversion")));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                this.f3651b.f3648d.mo1970a("");
                return;
            }
        }
        this.f3651b.f3648d.mo1970a(this.f3652c.c);
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3651b.f3648d.mo1970a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3652c.b == 3;
    }
}
