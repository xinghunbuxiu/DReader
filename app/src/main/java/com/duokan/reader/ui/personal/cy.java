package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.p043b.C0703c;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import java.io.File;

class cy extends WebSession {
    /* renamed from: a */
    final /* synthetic */ File f8436a;
    /* renamed from: b */
    final /* synthetic */ String f8437b;
    /* renamed from: c */
    final /* synthetic */ ct f8438c;
    /* renamed from: d */
    private C0621a<String> f8439d = null;
    /* renamed from: e */
    private boolean f8440e = false;

    cy(ct ctVar, C0657i c0657i, File file, String str) {
        this.f8438c = ctVar;
        this.f8436a = file;
        this.f8437b = str;
        super(c0657i);
    }

    protected void onSessionTry() {
        File parentFile = this.f8436a.getParentFile();
        String name = this.f8436a.getName();
        String[] list = parentFile.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(name)) {
                    new File(parentFile.getAbsolutePath() + "/" + str).delete();
                }
            }
        }
        C0703c c0703c = new C0703c(this);
        ExtendedAuthToken.parse(this.f8437b);
        try {
            this.f8439d = c0703c.m3391e(this.f8438c.f8429g);
        } catch (AuthenticationFailureException e) {
            this.f8440e = true;
            throw e;
        }
    }

    protected void onSessionSucceeded() {
        if (this.f8439d.b == 0) {
            MiAccount miAccount = (MiAccount) C0709k.m3476a().m3502b(MiAccount.class);
            miAccount.m3204e(this.f8438c.f8429g);
            this.f8438c.f8428f.mo1897b();
            miAccount.mo829a(null, new cz(this));
            return;
        }
        this.f8438c.f8428f.mo1895a(this.f8439d.c);
    }

    protected void onSessionFailed() {
        if (this.f8440e) {
            C0542e.m2411a(DkApp.get().getApplicationContext()).m2397a("com.xiaomi", this.f8437b);
            this.f8438c.m11641b(this.f8438c.f8428f);
            return;
        }
        this.f8438c.f8428f.mo1895a(this.f8438c.f8423a.getString(C0258j.general__shared__network_error));
    }
}
