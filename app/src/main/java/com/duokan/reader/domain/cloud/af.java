package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.bookshelf.kg;
import org.json.JSONObject;

class af extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f3670a;
    /* renamed from: b */
    final /* synthetic */ DkCloudReadingInfo f3671b;
    /* renamed from: c */
    final /* synthetic */ int f3672c;
    /* renamed from: d */
    final /* synthetic */ kg f3673d;
    /* renamed from: e */
    final /* synthetic */ DkCloudReadingInfo f3674e;
    /* renamed from: f */
    final /* synthetic */ al f3675f;
    /* renamed from: g */
    final /* synthetic */ String f3676g;
    /* renamed from: h */
    final /* synthetic */ DkCloudStorage f3677h;
    /* renamed from: i */
    private C0621a<Void> f3678i = null;

    af(DkCloudStorage dkCloudStorage, String str, C0657i c0657i, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo, int i, kg kgVar, DkCloudReadingInfo dkCloudReadingInfo2, al alVar, String str2) {
        this.f3677h = dkCloudStorage;
        this.f3670a = c0672a;
        this.f3671b = dkCloudReadingInfo;
        this.f3672c = i;
        this.f3673d = kgVar;
        this.f3674e = dkCloudReadingInfo2;
        this.f3675f = alVar;
        this.f3676g = str2;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.f3670a);
        JSONObject jSONObject = new JSONObject();
        this.f3671b.fillJsonObjectWithReadingProgress(jSONObject);
        this.f3678i = dkSyncService.m2823a(this.f3671b.getCloudId(), this.f3671b.getBookName(), this.f3671b.getIsDuokanBook(), this.f3672c, (int) (this.f3673d.f3453a / 1000), this.f3673d.f3454b, this.f3673d.f3455c, jSONObject);
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3678i.b == 0) {
            this.f3674e.setReadingProgress(this.f3671b.getReadingProgress());
            this.f3675f.mo1112a(this.f3671b, this.f3674e, this.f3676g);
            return;
        }
        this.f3675f.mo1113a(this.f3671b, this.f3678i.c, this.f3676g);
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3675f.mo1113a(this.f3671b, str, this.f3676g);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3678i.b == 3;
    }
}
