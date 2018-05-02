package com.duokan.reader.domain.account.p042a;

import android.accounts.Account;
import android.text.TextUtils;
import com.alipay.android.client.Aes;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.C0705g;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.domain.account.cm;
import com.duokan.reader.domain.account.p043b.C0701a;
import com.duokan.reader.domain.account.p043b.C0702b;
import java.util.HashMap;

/* renamed from: com.duokan.reader.domain.account.a.x */
class C0696x extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f2341a;
    /* renamed from: b */
    final /* synthetic */ Account f2342b;
    /* renamed from: c */
    final /* synthetic */ String f2343c;
    /* renamed from: d */
    final /* synthetic */ C0695w f2344d;
    /* renamed from: e */
    private C0621a<C0701a> f2345e = null;

    C0696x(C0695w c0695w, C0657i c0657i, String str, Account account, String str2) {
        this.f2344d = c0695w;
        this.f2341a = str;
        this.f2342b = account;
        this.f2343c = str2;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f2345e = new C0702b(this).m3388a(this.f2342b.name, Aes.encrypt_Base64(this.f2341a, "s87PfD3FczE5z01XaB6YacbG9lQc20A3"));
    }

    protected void onSessionSucceeded() {
        if (this.f2345e.b != 0) {
            this.f2344d.m3350a(this.f2345e.c);
            return;
        }
        boolean h = C0538a.m2388a(DkApp.get()).m2408h();
        if (TextUtils.equals(this.f2344d.f2339a.mo834d(), ((C0701a) this.f2345e.f2058a).f2398a)) {
            HashMap hashMap = new HashMap();
            hashMap.put("TokenDuplicated", this.f2344d.f2339a.mo834d());
            UmengManager.get().onEvent("ERROR_TRACK_V1", hashMap);
        } else {
            C0705g bdVar = new bd(this.f2342b.name);
            Account j = C0538a.m2388a(DkApp.get()).m2410j();
            if (j == null) {
                bdVar.f2401a = h ? this.f2343c : null;
            } else {
                String str = (!h || TextUtils.equals(j.name, this.f2342b.name)) ? null : this.f2343c;
                bdVar.f2401a = str;
            }
            bdVar.f2402b = this.f2341a;
            this.f2344d.f2339a.m3197a(new cm(this.f2342b.name, ((C0701a) this.f2345e.f2058a).f2398a, bdVar));
        }
        if (!h) {
            C0538a.m2388a(DkApp.get()).m2400a(this.f2342b, null, null);
        }
        this.f2344d.m3351b();
    }

    protected void onSessionFailed() {
        this.f2344d.m3350a(DkApp.get().getString(C0247i.general__shared__network_error));
    }
}
