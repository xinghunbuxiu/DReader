package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.l */
class C0852l extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4082a;
    /* renamed from: b */
    final /* synthetic */ C0851k f4083b;
    /* renamed from: c */
    private C0621a<JSONObject> f4084c = null;

    C0852l(C0851k c0851k, String str, C0657i c0657i, C0672a c0672a) {
        this.f4083b = c0851k;
        this.f4082a = c0672a;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.f4082a);
        if (this.f4083b.f4078a != null && this.f4083b.f4078a.length() > 0) {
            dkSyncService.m2827a(this.f4083b.f4078a);
        }
        this.f4084c = dkSyncService.m2821a();
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f4083b.f4081d.f4069d.m3499a(this.f4082a)) {
            this.f4083b.f4079b.mo1089a("");
        } else if (this.f4084c.b != 0) {
            this.f4083b.f4079b.mo1089a(this.f4084c.c);
        } else {
            DkCloudStatisticsInfo a = this.f4083b.f4081d.m5602a(this.f4082a, false);
            a.update(this.f4084c);
            if (this.f4083b.f4078a != null && this.f4083b.f4078a.length() > 0) {
                HashMap hashMap = new HashMap(a.mNewDistribution);
                Iterator keys = this.f4083b.f4078a.keys();
                while (keys.hasNext()) {
                    try {
                        hashMap.remove(Long.valueOf(Long.parseLong((String) keys.next())));
                    } catch (Throwable th) {
                    }
                }
                a.mNewDistribution = hashMap;
            }
            this.f4083b.f4081d.m5617a(a);
            this.f4083b.f4081d.m5613j();
            this.f4083b.f4079b.mo1088a();
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f4083b.f4079b.mo1089a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f4084c.b == 3 && this.f4083b.f4080c;
    }
}
